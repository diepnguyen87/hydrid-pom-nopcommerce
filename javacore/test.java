public class test {

	public void a() {
		System.out.println(this.getClass());
	}
	public static void main(String[] args){
		test t1 = new test();
		t1.a();
	}
}
