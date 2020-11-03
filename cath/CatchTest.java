package sf.cath;

/**
 * @Description :
 * @Author :
 * @Date: 2020-10-29 16:42
 */
public class CatchTest {

    public String invoke() {
        try {
            a();
            return "n";
        } catch (RuntimeException e) {
            b();
        } finally {
            finallyInvoke();
//            return "end";
        }
        return "e";
    }

    private void a() {
        throw new RuntimeException();
    }

    private void b() {
    }

    private void finallyInvoke() {
        System.out.println("finallyInvoke");
    }

    public static void main(String[] args) {
        CatchTest c = new CatchTest();
        String invoke = c.invoke();
        System.out.println(invoke);
    }
}
