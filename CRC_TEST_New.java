import java.util.Scanner;

public class CRC_TEST {

	public static void main(String[] args) {
		System.out.println("Please input the data that you want to send: ");//the sender input the data, that he wants to send
		Scanner in= new Scanner(System.in);//create a new scanner to get the data
		String str = in.next();//the input value is given to str
		
		String a = crc16(str);//invoking the function crc16()
		
		in.close();//close the scanner
		System.out.println("CRC is ： "+ a);// output the encrypted data
		
	}
		


public static String crc16(String str){
	int str_length, i, r;
	byte bit;
	int c;
	str_length = str.length();//get the length of the String
	byte[] data = str.getBytes();//get the bytes of the string
	int crc = 0x0000FFFF;//create a 16 bit integer, and make each bit as binary "0"
	for (i = 0; i < str_length; i++){
		c = (int)(crc>>8);//let the integer "crc" move 8 bit to the left(add 8 bit after "crc") with sign
		crc = (int)(c^data[i]);//let "c" and "data[i]" do the "exclusive OR" calculation
		for (r = 0; r < 8; r++){
			bit = (byte)(crc & 0x00000001);//let crc compare with a 8 bit data "1"
			crc >>>=1;//crc move 1 bit to the right without sign
			if (bit != 0 )// if bit ≠ 0
				crc ^= 0x0000A001;//according to the polynomial x^16+x^15+x^2+1
		}
	}
		return Integer.toHexString(crc);//change the string value crc to a integer value
	}
}
		
		



