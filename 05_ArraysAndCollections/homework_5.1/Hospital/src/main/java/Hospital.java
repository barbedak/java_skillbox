public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {

        //TODO: напишите метод генерации массива температур пациентов
        float[] temperatureData = new float[patientsCount];
        for (int i = 0; i < patientsCount; i++){
            temperatureData[i] = (float) (Math.random() * 8 + 32.0F);
        }

        return temperatureData;
    }

    public static String getReport(float[] temperatureData) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
        */
        String report = "Температуры пациентов:";
        float sumTemp = 0.0F;
        int amountHealthyPatients = 0;
        for (float temperature : temperatureData){
            if (temperature >= 36.2F && temperature <= 36.9F) { amountHealthyPatients++; }
            report = report.concat(" " + temperature);
            sumTemp += temperature;
        }

        float averageTemp = (float) (Math.round(sumTemp / temperatureData.length * 10.0) / 10.0);
        report = report.concat("\nСредняя температура: " + averageTemp + "\nКоличество здоровых: " + amountHealthyPatients);
        return report;
    }
}
