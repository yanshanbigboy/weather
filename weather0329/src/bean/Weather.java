package bean;

public class Weather {
	int month; // �·�
	String province; // ʡ��
	double avgPressure; // ƽ����ѹ
	double avgTemperature; // ƽ������
	int avgHumidity; // ƽ��ʪ��
	double avgPrecipitation; // ƽ����ˮ��
	double avgWindSpeed; // ƽ������
	int population;

	public Weather() {

	}

	public Weather(int mounth, String province, double avgPressure,
			double avgTemperature, int avgHumidity, double avgPrecipitation,
			double avgWindSpeed, int population) {
		this.month = mounth;
		this.province = province;
		this.avgPressure = avgPressure;
		this.avgTemperature = avgTemperature;
		this.avgHumidity = avgHumidity;
		this.avgPrecipitation = avgPrecipitation;
		this.avgWindSpeed = avgWindSpeed;
		this.population = population;
	}

	public Weather(int mounth, String province, double avgPressure,
			double avgTemperature, int avgHumidity, double avgPrecipitation,
			double avgWindSpeed) {
		this.month = mounth;
		this.province = province;
		this.avgPressure = avgPressure;
		this.avgTemperature = avgTemperature;
		this.avgHumidity = avgHumidity;
		this.avgPrecipitation = avgPrecipitation;
		this.avgWindSpeed = avgWindSpeed;
	}

	// ����delWeather
	public Weather(int month, String province) {
		this.month = month;
		this.province = province;
	}

	// ����delProvince
	public Weather(String province) {
		this.province = province;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getMonth() {
		return month;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getProvince() {
		return province;
	}

	public void setAvgpressure(double avgpressure) {
		this.avgPressure = avgpressure;
	}

	public double getAvgPressure() {
		return avgPressure;
	}

	public void setAvgTemperature(double avgTemperature) {
		this.avgTemperature = avgTemperature;
	}

	public double getAvgTemperature() {
		return avgTemperature;
	}

	public void setAvgHumidity(int avgHumidity) {
		this.avgHumidity = avgHumidity;
	}

	public int getAvgHumidity() {
		return avgHumidity;
	}

	public void setAvgPrecipitation(double avgPrecipitation) {
		this.avgPrecipitation = avgPrecipitation;
	}

	public double getAvgPrecipitation() {
		return avgPrecipitation;
	}

	public void setAvgWindSpeed(double avgWindSpeed) {
		this.avgWindSpeed = avgWindSpeed;
	}

	public double getAvgWindSpeed() {
		return avgWindSpeed;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public int getPopulation() {
		return population;
	}
}
