
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author TEXR
 */
public class IfDrawing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("กรุณาใส่ความสูงของตึก: ");
        int times = sc.nextInt();

        for (int i = 0; i < times; i++) {
            System.out.println("#-#-#-#-#");
        }
    }
}
