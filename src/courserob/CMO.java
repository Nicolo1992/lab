package courserob;

import javax.swing.JOptionPane;

public class CMO { // класс для описания CMO

    int n; // количество каналов
    double L; // интенсивность входного потока
    double t; // время обслуживания одной заявки
    double mu; // интенсивность потока обслуживания
// функция вычисления интенсивности нагрузки

    double Service(double t, double L) {
        double p = 0.0; //интенсивность нагрузки
        p = L * t;
        return p;
    }
// функция вычисления вероятности что канал свободен

    double probability_e(int k, double p) {
        double m = 0.0;
        double l = 1.0;
        for (int i = 0; i <= k; i++) {
            m = m + l;
            l *= p / (i + 1);
        }
        double p0 = 1 / m; // p0 - вероятность, что канал свободен
        return p0;
    }
// функция вычисления вероятности отказа

    double probability_ot(int n, double p, double p0) {
        double k = 1.0;
        for (int i = 1; i <= n; i++) {
            k = k * i;
        }
        double otk = (Math.pow(p, n) / k) * p0; //otk - вероятность отказа
        return otk;
    }
// функция вычисления вероятности обслуживания

    double probability_ob(double otk) {
        double obs = 1 - otk; // obs - вероятность обслуживания
        return obs;
    }
    String C, A, B, D;
//объявление метода ввода числа

    void getNumber() {
        C = JOptionPane.showInputDialog("Введите кол-во каналов n");
        A = JOptionPane.showInputDialog("Введите интенсивность входного потока L");
        B = JOptionPane.showInputDialog("Введите время обслуживания одной заявки t");
        D = JOptionPane.showInputDialog("Интенсивность потока обслуживания mu");
    }
//объявление метода преобразования строки в число

    void receiveNumber() {
        n = Integer.parseInt(C);
        L = Double.valueOf(A).doubleValue();
        t = Double.valueOf(B).doubleValue();
        mu = Double.valueOf(D).doubleValue();
    }
}
