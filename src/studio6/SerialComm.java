package studio6;

import jssc.*;

public class SerialComm {

	SerialPort port;

	private boolean debug;  // Indicator of "debugging mode"
	
	// This function can be called to enable or disable "debugging mode"
	void setDebug(boolean mode) {
		debug = mode;
	}	
	

	// Constructor for the SerialComm class
	public SerialComm(String name) throws SerialPortException {
		port = new SerialPort(name);		
		port.openPort();
		port.setParams(SerialPort.BAUDRATE_9600,
			SerialPort.DATABITS_8,
			SerialPort.STOPBITS_1,
			SerialPort.PARITY_NONE);
		
		debug = false; // Default is to NOT be in debug mode
	}
		
	public void writeByte(byte singleByte) {
		try {
			port.writeByte(singleByte);
		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (debug)
			System.out.println(singleByte);
	}
	
	public static boolean available() {
		try {
			if(port.getInputBufferBytesCount()!=-1)
				return true;
			else
				return false;
		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
	
	public static void readByte() throws SerialPortException {
		byte[] c = new byte[1];
		c = port.readBytes(1);
		System.out.println((char) c[0]);
	}
	
	
	public static void main()
	{
		while (true)
		{
			if (available())
				readByte();
		}
	}
	// TODO: Add a main() method
}
