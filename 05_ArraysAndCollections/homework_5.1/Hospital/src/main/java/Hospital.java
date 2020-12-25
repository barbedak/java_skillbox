public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {

        //TODO: напишите метод генерации массива температур пациентов
        float[] patientTemp = new float[patientsCount];
        for (int i = 0; i < patientsCount; i++){
            patientTemp[i] = (float) (Math.random() * 8 + 32.0F);
        }

        return patientTemp;
    }

    public static String getReport(float[] temperatureData) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
        */
        String report = "Температуры пациентов:";
        float sumTemp = 0.0F;
        int healthyPatient = 0;
        for (float temp : temperatureData){
            if (temp >= 36.2F && temp <= 36.9F) { healthyPatient++; }
            report = report.concat(" " + temp);
            sumTemp += temp;
        }

        float midTemp = (float) (Math.round(sumTemp / temperatureData.length * 10.0) / 10.0);
        report = report.concat("\nСредняя температура: " + midTemp + "\nКоличество здоровых: " + healthyPatient);
        return report;
    }
}
