import java.util.Scanner;

public class CRC_TEST {

	public static void main(String[] args) {
		System.out.println("Please input the data that you want to send: ");//输入要发送的数据
		Scanner in= new Scanner(System.in);//scanner输入
		String str = in.next();//输入
		
		String a = crc16(str);
		
		in.close();
		System.out.println("CRC is ： "+ a);
		
	}
		// TODO Auto-generated method stub
	


public static String crc16(String str){
	int str_length, i, r;
	byte bit;
	int c;
	str_length = str.length();
	byte[] data = str.getBytes();
	int crc = 0x0000FFFF;
	for (i = 0; i < str_length; i++){
		c = (int)(crc>>8);
		crc = (int)(c^data[i]);
		for (r = 0; r < 8; r++){
			bit = (byte)(crc & 0x00000001);
			crc >>>=1;
			if (bit != 0 )
				crc ^= 0x0000A001;
		}
	}
		return Integer.toHexString(crc);
	}
}
		
		



