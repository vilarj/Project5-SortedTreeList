package encoding;

public class Message {
	char[] msg;
	
	public Message(char c1, char c2, char c3) {
		this.msg = new char[3];
		
		msg[0] = c1;
		msg[1] = c2;
		msg[2] = c3;
	}
	
	public char[] getMsg() {
		return msg;
	}

	public void setMsg(char[] msg) {
		this.msg = msg;
	}

	public String toString() {
		return Character.toString(msg[0]) + Character.toString(msg[1]) + Character.toString(msg[2]);
	}
	
}
