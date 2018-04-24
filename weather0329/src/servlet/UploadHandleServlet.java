package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.file;
import dao.FileDao;

/**
 * @ClassName: UploadHandleServlet
 */
public class UploadHandleServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @Method: makeFileName
	 * @Description: �����ϴ��ļ����ļ������ļ����ԣ�uuid+"_"+�ļ���ԭʼ����
	 * @param filename
	 *            �ļ���ԭʼ����
	 * @return uuid+"_"+�ļ���ԭʼ����
	 */
	private String makeFileName(String filename) { // 2.jpg
		// Ϊ��ֹ�ļ����ǵ���������ҪΪ�ϴ��ļ�����һ��Ψһ���ļ���
		return UUID.randomUUID().toString() + "_" + filename;
	}

	/**
	 * Ϊ��ֹһ��Ŀ¼�������̫���ļ���Ҫʹ��hash�㷨��ɢ�洢
	 * 
	 * @Method: makePath
	 * @Description:
	 * 
	 * @param filename
	 *            �ļ�����Ҫ�����ļ������ɴ洢Ŀ¼
	 * @param savePath
	 *            �ļ��洢·��
	 * @return �µĴ洢Ŀ¼
	 */
	private String makePath(String filename, String savePath) {
		// �õ��ļ�����hashCode��ֵ���õ��ľ���filename����ַ����������ڴ��еĵ�ַ
		int hashcode = filename.hashCode();
		int dir1 = hashcode & 0xf; // 0--15
		int dir2 = (hashcode & 0xf0) >> 4; // 0-15
		// �����µı���Ŀ¼
		String dir = savePath + "\\" + dir1 + "\\" + dir2; // upload\2\3
															// upload\3\5
		// File�ȿ��Դ����ļ�Ҳ���Դ���Ŀ¼
		File file = new File(dir);
		// ���Ŀ¼������
		if (!file.exists()) {
			// ����Ŀ¼
			file.mkdirs();
		}
		return dir;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// String fileMess1=request.getParameter("fileMess1");
		// System.out.println("fileMess1=="+fileMess1);
		// String fileMess2=request.getParameter("fileMess2");
		// �õ��ϴ��ļ��ı���Ŀ¼�����ϴ����ļ������WEB-INFĿ¼�£����������ֱ�ӷ��ʣ���֤�ϴ��ļ��İ�ȫ
		String savePath = this.getServletContext().getRealPath(
				"/WEB-INF/upload");
		// �ϴ�ʱ���ɵ���ʱ�ļ�����Ŀ¼
		String tempPath = this.getServletContext().getRealPath("/WEB-INF/temp");
		File tmpFile = new File(tempPath);
		if (!tmpFile.exists()) {
			// ������ʱĿ¼
			tmpFile.mkdir();
		}

		// ��Ϣ��ʾ
		String message = "";
		try {
			// ʹ��Apache�ļ��ϴ���������ļ��ϴ����裺
			// 1������һ��DiskFileItemFactory����
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// ���ù����Ļ������Ĵ�С�����ϴ����ļ���С�����������Ĵ�Сʱ���ͻ�����һ����ʱ�ļ���ŵ�ָ������ʱĿ¼���С�
			factory.setSizeThreshold(1024 * 100);// ���û������Ĵ�СΪ100KB�������ָ������ô�������Ĵ�СĬ����10KB
			// �����ϴ�ʱ���ɵ���ʱ�ļ��ı���Ŀ¼
			factory.setRepository(tmpFile);
			// 2������һ���ļ��ϴ�������
			ServletFileUpload upload = new ServletFileUpload(factory);
			// �����ļ��ϴ�����
			upload.setProgressListener(new ProgressListener() {
				public void update(long pBytesRead, long pContentLength,
						int arg2) {
					System.out.println("�ļ���СΪ��" + pContentLength + ",��ǰ�Ѵ���"
							+ pBytesRead);
					/**
					 * �ļ���СΪ��14608,��ǰ�Ѵ���4096 �ļ���СΪ��14608,��ǰ�Ѵ���7367
					 * �ļ���СΪ��14608,��ǰ�Ѵ���11419 �ļ���СΪ��14608,��ǰ�Ѵ���14608
					 */
				}
			});
			// ����ϴ��ļ�������������
			upload.setHeaderEncoding("UTF-8");
			// 3���ж��ύ�����������Ƿ����ϴ���������
			if (!ServletFileUpload.isMultipartContent(request)) {
				// ���մ�ͳ��ʽ��ȡ����
				return;
			}

			// �����ϴ������ļ��Ĵ�С�����ֵ��Ŀǰ������Ϊ1024*1024*110�ֽڣ�Ҳ����110MB
			upload.setFileSizeMax(1024 * 1024 * 110);
			// �����ϴ��ļ����������ֵ�����ֵ=ͬʱ�ϴ��Ķ���ļ��Ĵ�С�����ֵ�ĺͣ�Ŀǰ����Ϊ110MB
			upload.setSizeMax(1024 * 1024 * 110);
			// 4��ʹ��ServletFileUpload�����������ϴ����ݣ�����������ص���һ��List<FileItem>���ϣ�ÿһ��FileItem��Ӧһ��Form����������
			List<FileItem> list = upload.parseRequest(request);

			file file = new file();
			for (FileItem item : list) {
				String value = "";
				if (item.isFormField()) {

					// ���fileitem�з�װ������ͨ�����������
					String name = item.getFieldName();
					// �����ͨ����������ݵ�������������
					value = item.getString("UTF-8");
					file.setFileMess(value);
					// value = new String(value.getBytes("iso8859-1"),"UTF-8");
					System.out.println("nameif==" + name + "valueif==" + value);
				} else {
					// ���fileitem�з�װ�����ϴ��ļ�
					// �õ��ϴ����ļ����ƣ�
					String filename = item.getName();
					if (filename == null || filename.trim().equals("")) {
						continue;
					}
					// ע�⣺��ͬ��������ύ���ļ����ǲ�һ���ģ���Щ������ύ�������ļ����Ǵ���·���ģ��磺
					// c:\a\b\1.txt������Щֻ�ǵ������ļ������磺1.txt
					// �����ȡ�����ϴ��ļ����ļ�����·�����֣�ֻ�����ļ�������
					filename = filename
							.substring(filename.lastIndexOf("\\") + 1);
					// �õ��ϴ��ļ�����չ��
					String fileExtName = filename.substring(filename
							.lastIndexOf(".") + 1);
					// �����Ҫ�����ϴ����ļ����ͣ���ô����ͨ���ļ�����չ�����ж��ϴ����ļ������Ƿ�Ϸ�
					System.out.println("�ϴ����ļ�����չ���ǣ�" + fileExtName);
					// ��ȡitem�е��ϴ��ļ���������
					InputStream in = item.getInputStream();
					// �õ��ļ����������
					String saveFilename = makeFileName(filename);
					// �õ��ļ��ı���Ŀ¼
					String realSavePath = makePath(saveFilename, savePath);
					float fileSize=(float)Math.round(((float)item.getSize())/1024/1024*100)/100;
					file.setFileName(filename);
					file.setFileURL(realSavePath);
					file.setRealFileName(saveFilename);
					file.setFileSize(fileSize);
					System.out.println("servlet upload file.fileSize="+file.getFileSize());
					// ����һ���ļ������
					FileOutputStream out = new FileOutputStream(realSavePath
							+ "\\" + saveFilename);
					// ����һ��������
					byte buffer[] = new byte[1024];
					// �ж��������е������Ƿ��Ѿ�����ı�ʶ
					int len = 0;
					// ѭ�������������뵽���������У�(len=in.read(buffer))>0�ͱ�ʾin���滹������
					while ((len = in.read(buffer)) > 0) {
						// ʹ��FileOutputStream�������������������д�뵽ָ����Ŀ¼(savePath + "\\"
						// + filename)����
						out.write(buffer, 0, len);
					}
					// �ر�������
					in.close();
					// �ر������
					out.close();
					// ɾ�������ļ��ϴ�ʱ���ɵ���ʱ�ļ�
					// item.delete();
				}
			}
			System.out.println("filemesss==" + file.getFileMess());
			int i = FileDao.addFileINFO(file);

			if (i == 0) {/* item.getString("UTF-8") */
				System.out.println("mysqlд��ʧ��");
			} else {
				System.out.println("mysqlд��ɹ�");
			}

			message = String
					.format("�ļ��ϴ��ɹ����Զ���ת���ļ��ϴ�ҳ��<meta http-equiv='refresh' content='2;url=%s'/>",
							request.getContextPath() + "/Upload.jsp");
		} catch (FileUploadBase.FileSizeLimitExceededException e) {
			e.printStackTrace();
			message = String
					.format("�����ļ��������ֵ���Զ���ת���ļ��ϴ�ҳ��<meta http-equiv='refresh' content='2;url=%s'/>",
							request.getContextPath() + "/Upload.jsp");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/pattern/Message.jsp").forward(
					request, response);
			return;
		} catch (FileUploadBase.SizeLimitExceededException e) {
			e.printStackTrace();
			message = String
					.format("�ϴ��ļ����ܵĴ�С�������Ƶ����ֵ���Զ���ת���ļ��ϴ�ҳ��<meta http-equiv='refresh' content='2;url=%s'/>",
							request.getContextPath() + "/Upload.jsp");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/pattern/Message.jsp").forward(
					request, response);
			return;
		} catch (Exception e) {
			message = "�ļ��ϴ�ʧ�ܣ�";
			e.printStackTrace();
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("/pattern/Message.jsp").forward(request,
				response);
	}
}