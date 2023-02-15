package chap13;
import java.util.Scanner;
class Cal {
    private float num1;
    private char op;
    private float num2;
    public Cal() {}
    public Cal(float num1,char op,float num2) {
        this.num1 = num1;
        this.op = op;
        this.num2 = num2;
    }
    public void init() {
        System.out.println("��������ʽ����ʽΪ��45 + 56");
        Scanner sc = new Scanner(System.in);
        num1 = sc.nextFloat();
        op = sc.next().charAt(0);
        num2 = sc.nextFloat();
    }
    public float cal() {
        float result = 0;
        switch(op) {
            case'+':result = num1 + num2;break;
            case'-':result = num1 - num2;break;
            case'*':result = num1 * num2;break;
            case'/':result = num1 / num2;break;
            default:System.out.println("���������");
        }
        return result;
    }
}