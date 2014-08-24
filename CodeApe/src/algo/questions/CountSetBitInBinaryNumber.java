package algo.questions;

public class CountSetBitInBinaryNumber {

	public static void main(String[] args) {
		CountSetBitInBinaryNumber ins = new CountSetBitInBinaryNumber();
		System.out.println(ins.countSetBit("0"));
		System.out.println(ins.countSetBit("01"));
		System.out.println(ins.countSetBit("110"));
		System.out.println(ins.countSetBit("0001110"));
		System.out.println(ins.countSetBit("1110001"));
		System.out.println(ins.countSetBit("101010101"));
		System.out.println(ins.countSetBit("011100011101010101000"));
	}

	public int countSetBit(String binary) {
		int num = Integer.parseInt(binary, 2);
		int count = 0;
		while (num != 0) {
			num &= num - 1;
			count++;
		}
		return count;
	}
}
