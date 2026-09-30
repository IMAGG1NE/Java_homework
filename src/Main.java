
import java.util.Scanner;

/*Итак, задание на первую практическую работу: написать класс для работы
 с матрицами комплексных чисел. В классе должны быть методы,
  позволяющие сложить, перемножить, разделить матрицы (при возможности),
   транспонировать и вычислить определитель. К классу должен прилагаться консольный интерфейс,
    позволяющий создать матрицу и задать операцию. Сдавать в виде ссылки на гитхаб (предпочтительно)
     или в виде приаттаченных Java файлов. Срок сдачи до 15.10 Вопросы по заданию
 задавать здесь. Выполненные работы присылать на адрес
 */

public class Main {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Здравствуйте, вас приветсвует MatrixMaster выберите опцию:");

        while(true){
            System.out.println("1) Сложить матрицы\n2) умножить матрицы\n3) разделить матрицы\n4) транспонировать матрицу\n5) вычислить определитель\n0) выйти из программы");
            int choice = scanner.nextInt();
            if(choice == 0){
                break;
            }
            switch (choice){
                case 1->{
                    System.out.println("Вы выбрали сложить матрицы");
                    System.out.println("введите размерности матрицы(N X M)");
                    int n = scanner.nextInt();
                    int m = scanner.nextInt();

                    Matrix copmlex_matrix_1 = new Matrix(n, m);
                    System.out.println("Заполните матрицу (формат ввода без пробелов, например: 7+10i, -3.5i, 5):");
                    copmlex_matrix_1.assign_matrix(scanner);

                    Matrix copmlex_matrix_2 = new Matrix(n, m);
                    System.out.println("Заполните матрицу (формат ввода без пробелов, например: 7+10i, -3.5i, 5):");
                    copmlex_matrix_2.assign_matrix(scanner);

                    Matrix result_matrix = copmlex_matrix_1.add(copmlex_matrix_2);
                    result_matrix.print_matrix();
                }
                case 2 ->{
                    System.out.println("Вы выбрали умножить матрицы");
                    boolean flag = false;
                    do {
                        System.out.println("введите размерности матрицы(N X M)");
                        int n1 = scanner.nextInt();
                        int m1 = scanner.nextInt();

                        System.out.println("введите размерности матрицы(N X M)");
                        int n2 = scanner.nextInt();
                        int m2 = scanner.nextInt();
                        if(m1 != n2){
                            System.out.println("Размерности матриц не удовлетворяют условиям умножения матриц, попробуйте еще раз");
                            continue;
                        }
                        Matrix copmlex_matrix_1 = new Matrix(n1, m1);
                        System.out.println("Заполните матрицу (формат ввода без пробелов, например: 7+10i, -3.5i, 5):");
                        copmlex_matrix_1.assign_matrix(scanner);

                        Matrix copmlex_matrix_2 = new Matrix(n2, m2);
                        System.out.println("Заполните матрицу (формат ввода без пробелов, например: 7+10i, -3.5i, 5):");
                        copmlex_matrix_2.assign_matrix(scanner);
                        Matrix res_matrix = copmlex_matrix_1.mult(copmlex_matrix_2);
                        res_matrix.print_matrix();
                        flag =true;
                    }while(!flag);


                }
                case 3 ->{
                    System.out.println("Вы выбрали делить матрицы A/B");
                    System.out.println("Введите размерности Матрицы A");
                    int n1 = scanner.nextInt();
                    int m1 = scanner.nextInt();

                    System.out.println("Введите размерность матрицы B");
                    int n2 = scanner.nextInt();
                    int m2 = scanner.nextInt();
                    if(n2 != m2){
                        System.out.println("Размерности матрицы B должны совпадать друг с другом");
                        break;
                    }
                    if(m1 != n2){
                        System.out.println("количество столбцов A должно совпадать с количеством строк B");
                        break;
                    }
                    System.out.println("Заполните матрицу (формат ввода без пробелов, например: 7+10i, -3.5i, 5):");
                    Matrix complex_matrix_1 = new Matrix(n1, m1);
                    complex_matrix_1.assign_matrix(scanner);

                    System.out.println("Заполните матрицу (формат ввода без пробелов, например: 7+10i, -3.5i, 5):");
                    Matrix complex_matrix_2 = new Matrix(n2, m2);
                    complex_matrix_2.assign_matrix(scanner);
                    if(complex_matrix_2.det().abs() < 1e-6){
                        System.out.println("Определитель матрицы B = 0, Деление на вырожденную матрицу невозможно");
                        break;
                    }
                    Matrix complex_matrix_2_inverse = complex_matrix_2.inverse();
                    Matrix complex_matrix_res =complex_matrix_1.mult(complex_matrix_2_inverse);
                    complex_matrix_res.print_matrix();
                }
                case 4 ->{
                    System.out.println("Вы выбрали транспонировать матрицу");
                    System.out.println("введите размерности матрицы(N X M)");
                    int n = scanner.nextInt();
                    int m = scanner.nextInt();

                    Matrix complex_matrix = new Matrix(n, m);
                    System.out.println("Заполните матрицу (формат ввода без пробелов, например: 7+10i, -3.5i, 5):");
                    complex_matrix.assign_matrix(scanner);

                    System.out.println("Транспонированная матрица:");
                    Matrix transposed_matrix = complex_matrix.transpose_matrix();
                    transposed_matrix.print_matrix();
                }
                case 5 ->{
                    System.out.println("Вы выбрали вычислить определитель");
                    System.out.println("Введите размерность матрицы(одно число)");
                    int n = scanner.nextInt();
                    Matrix complex_matrix = new Matrix(n, n);
                    System.out.println("Заполните матрицу (формат ввода без пробелов, например: 7+10i, -3.5i, 5):");
                    complex_matrix.assign_matrix(scanner);
                    System.out.println("Определитель матрицы = " + complex_matrix.det());

                }
            }
        }
        scanner.close();
    }

}

class Complex{
    private double real;
    private double imag;


    Complex(String complex_digit){
        int n = complex_digit.length();
        int first_sign_index = -1;
        for(int i = 1; i < n; i++){
            if(complex_digit.charAt(i) == '+' || complex_digit.charAt(i) == '-'){
                first_sign_index = i;
                break;
            }
        }
        if(first_sign_index == -1){
            if(complex_digit.charAt(n-1) == 'i'){
                String str_imag_part = complex_digit.substring(0, n-1);
                real = 0;
                if(str_imag_part.equals("-")){
                    imag = -1.0;
                }
                else if (str_imag_part.isEmpty() || str_imag_part.equals("+")){
                    imag = 1.0;
                }
                else{
                    imag = Double.parseDouble(str_imag_part);
                }
            }
            else{
                imag = 0;
                real = Double.parseDouble(complex_digit);
            }
        }
        else{
            real = Double.parseDouble(complex_digit.substring(0, first_sign_index));

            String str_imag_part = complex_digit.substring(first_sign_index, n-1);
            if(str_imag_part.equals("+")){
                imag = 1.0;
            }
            else if(str_imag_part.equals("-")){
                imag = -1.0;
            }
            else{
                imag = Double.parseDouble(str_imag_part);
            }
        }
    }
    Complex(double real, double imag){
        this.real = real;
        this.imag = imag;
    }

    Complex add(Complex complex_val){
        double res_real = real + complex_val.real;
        double res_imag = imag + complex_val.imag;
        return new Complex(res_real, res_imag);
    }
    Complex mult(Complex complex_val){
        double res_real = real * complex_val.real - imag * complex_val.imag;
        double imag_real =real * complex_val.imag + imag * complex_val.real;
        return new Complex(res_real, imag_real);
    }
    Complex div_by(Complex val){
        double znamen = val.real * val.real + val.imag * val.imag;

        if(znamen == 0){
            throw new ArithmeticException("Division by zero");
        }
        double imag_val = (imag * val.real - real * val.imag)/znamen;
        double real_val = (real*val.real + imag * val.imag)/znamen;
        return new Complex(real_val, imag_val);
    }
    Complex subtract(Complex val){
        return new Complex(real - val.real, imag - val.imag);
    }
    double abs(){
        return Math.sqrt(real*real + imag*imag);
    }
    public String toString(){
        double eps = 1e-6;
        if(Math.abs(real) <eps){
            return imag + "i";
        }
        if (Math.abs(imag) < eps) {
            return String.valueOf(real);
        }
        return String.format("%.2f %c %.2fi", real, (imag < 0) ? '-' : '+', Math.abs(imag));
    }
}

class Matrix{
    private int n;
    private int m;
    private Complex[][] matrix;
    Matrix(int n, int m){
        this.n = n;
        this.m = m;
        matrix = new Complex[n][m];
    }
    void assign_matrix(Scanner scanner){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                String complex_val = scanner.next();
                matrix[i][j] = new Complex(complex_val);
            }
        }
    }
    Matrix transpose_matrix(){
        Matrix transposed_matrix = new Matrix(m, n);
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                transposed_matrix.matrix[i][j] = matrix[j][i];
            }
        }
        return transposed_matrix;
    }
    Matrix add(Matrix another_matrix){
        Matrix res_matrix = new Matrix(n, m);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                res_matrix.matrix[i][j] = matrix[i][j].add(another_matrix.matrix[i][j]);
            }
        }
        return res_matrix;
    }
    Matrix mult(Matrix another_matrix){
        if(m != another_matrix.n){
            return new Matrix(0, 0);
        }
        Matrix res = new Matrix(n, another_matrix.m);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < another_matrix.m; j++){
                Complex s = new Complex(0, 0);
                for(int k = 0 ; k < m; k++){
                    Complex temp = matrix[i][k].mult(another_matrix.matrix[k][j]);
                    s = s.add(temp);
                }
                res.matrix[i][j] = s;
            }

        }
        return res;
    }
    Complex det(){
        Complex determ = new Complex(1, 0);
        double eps = 1e-6;
        Matrix matrix_copy = new Matrix(n, m);
        for(int i = 0; i < n; i++){
            for(int j =0 ;j < m; j++){
                matrix_copy.matrix[i][j] = matrix[i][j];
            }
        }
        for(int i = 0; i < n; i++){
            int k = i;
            for(int j = i+1; j < n; j++){
                if(matrix_copy.matrix[j][i].abs() > matrix_copy.matrix[k][i].abs()){
                    k = j;
                }
            }
            if(matrix_copy.matrix[k][i].abs() < eps){
                return new Complex(0, 0);
            }
            if(i != k){
                Complex[] tmp = matrix_copy.matrix[i];
                matrix_copy.matrix[i] = matrix_copy.matrix[k];
                matrix_copy.matrix[k] = tmp;
                determ = determ.mult(new Complex(-1, 0));
            }
            determ = determ.mult(matrix_copy.matrix[i][i]);
            for(int j = i+1; j < n; j++){
                Complex coef = matrix_copy.matrix[j][i].div_by(matrix_copy.matrix[i][i]);
                for(int p = i; p < n; p++){
                    matrix_copy.matrix[j][p] = matrix_copy.matrix[j][p].subtract(coef.mult(matrix_copy.matrix[i][p]));
                }
            }
        }
        return determ;

    }
    private Matrix minor(int crossed_row, int crossed_col){
        Matrix res_minor = new Matrix(n-1, m-1);
        int row_ind = 0;
        for(int i = 0; i < n; i++){
            if(i == crossed_row){
                continue;
            }
            int col_ind = 0;
            for(int j = 0; j < m; j++){
                if(j != crossed_col){
                    res_minor.matrix[row_ind][col_ind] = matrix[i][j];
                    col_ind++;
                }
            }
            row_ind++;
        }
        return res_minor;
    }
    public Matrix inverse(){
        Complex det = this.det();
        if(n == 1){
            Matrix res = new Matrix(1, 1);
            res.matrix[0][0] = new Complex(1, 0).div_by(det);
            return res;
        }
        Matrix res = new Matrix(n, n);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                Matrix minor = this.minor(i, j);
                Complex det_minor = minor.det();
                Complex coef = (((j+i)%2 == 1)? det_minor.mult(new Complex(-1, 0)): det_minor);
                res.matrix[j][i] = coef.div_by(det);
            }
        }
        return res;
    }

    void print_matrix(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(String.format("%-18s", matrix[i][j]));
            }
            System.out.println("");
        }
    }
}


