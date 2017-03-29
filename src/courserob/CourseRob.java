package courserob;

public class CourseRob {

    public static void main(String[] args) {
        try {
            CMO autowash = new CMO();
            /* данные для ввода
             autowash.n = 3;
             autowash.L = 2.167;
             autowash.t = 0.667;
             autowash.mu = 1.5;
             */
            autowash.getNumber();
            autowash.receiveNumber();
            System.out.println("Практические расчеты СМО:");
            double p = autowash.Service(autowash.t, autowash.L);
            System.out.printf("Интенсивность нагрузки = %1.3f\n", p);
            double p0 = autowash.probability_e(autowash.n, p);
            System.out.printf("вероятность, что каналы свободны = %1.3f\n", p0);
            probability_z(autowash.n, p, p0);
            double otk = autowash.probability_ot(autowash.n, p, p0);
            System.out.printf("вероятность, отказа = %1.3f\n", otk);
            double obs = autowash.probability_ob(otk);
            System.out.printf("вероятность, обслуживания = %1.3f\n", obs);
            kanal_state(autowash.n, p, obs);
            abs_abilities(autowash.L, obs, autowash.n, autowash.t);
            cred(otk, autowash.t, p, obs, autowash.mu);

        } catch (Exception e) {
            System.out.println("Error:" + e);
        }
    }
// метод вычисления интенсивности нагрузки

    public static void probability_z(int n, double p, double p0) {
        double z = 0.0;
        double k = 1.0;
        for (int i = 1; i <= n; i++) {
            k = k * i;
            z = Math.pow(p, i) / k * p0;
            System.out.println("вероятность, что" + " " + i); //+ " " + "канал занят = " + z);
            System.out.printf("канал занят = %1.3f\n", z);
        }
    }
// метод вычисления показателей

    public static void kanal_state(int n, double p, double obs) {
        double nz = p * obs;
        System.out.printf("среднее число каналов, занятых обслуживанием = %1.3f\n", nz);
        double np = n - nz;
        System.out.printf("среднее число каналов, простоя = %1.3f\n", np);
        double kz = nz / n;
        System.out.printf("коэффициент занятости каналов обслуживанием = %1.3f\n", kz);
    }
// метод вычисления аболютной пропускной способности

    public static void abs_abilities(double L, double obs, int n, double t) {
        double A = L * obs;
        System.out.printf("абсолютная пропускная способность = %1.3f\n", A);
        double N = n / t;
        System.out.printf("номинальная производительность = %1.3f\n", N);
        double F = A / N * 100;
        System.out.printf("фактическая производительность в процентах = %3.3f\n", F);
    }
// метод вычисления показателей смо

    public static void cred(double otk, double t, double p, double obs, double mu) {
        double tpr = otk * t;
        System.out.printf("среднее время простоя СМО = %2.3f\n", tpr);
        double Lobs = p * obs;
        System.out.printf("среднее число обслуживаемых заявок = %2.3f\n", Lobs);
        double T = obs / mu;
        System.out.printf("среднее время пребывания заявки в СМО = %2.3f\n", T);
    }
}
