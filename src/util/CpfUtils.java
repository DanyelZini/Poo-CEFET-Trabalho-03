package util;

public class CpfUtils {

    public static CpfUtils getInstance() {
        return new CpfUtils();
    }

    public static String formatarCpf(String cpf) {
        return cpf.replaceAll("[\\.\\-]", "");
    }

    public static boolean isCpfValido(String cpf) {
        cpf = formatarCpf(cpf);

        if (!cpf.matches("\\d{11}") || cpf.length() != 11)
            return false;

        int soma = 0;
        for (int i = 0; i < 9; i++)
            soma += (cpf.charAt(i) - '0') * (10 - i);
        int n1 = 11 - (soma % 11);
        if (n1 >= 10)
            n1 = 0;

        soma = 0;
        for (int i = 0; i < 10; i++)
            soma += (cpf.charAt(i) - '0') * (11 - i);
        int n2 = 11 - (soma % 11);
        if (n2 >= 10)
            n2 = 0;

        if (n1 != (cpf.charAt(9) - '0') || n2 != (cpf.charAt(10) - '0')) {
            return false;
        }

        return true;
    }
}
