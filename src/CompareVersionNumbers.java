/**
 * Created by shiyanch on 12/27/16.
 */
public class CompareVersionNumbers {
    public int compareVersion(String a, String b) {
        a = validate(a);
        b = validate(b);

        String[] versionA = a.split("[.]");
        String[] versionB = b.split("[.]");
        int i=0, j=0;

        while (i < versionA.length || j < versionB.length) {
            String aa = i < versionA.length?leadingZero(versionA[i]):"0";
            String bb = j < versionB.length?leadingZero(versionB[j]):"0";

            if (aa.length() != bb.length()) {
                return aa.length() > bb.length()?1:-1;
            }

            int index = 0;
            while (index < aa.length() || index < bb.length()) {
                char aaa = index < aa.length()?aa.charAt(index):'0';
                char bbb = index < bb.length()?bb.charAt(index):'0';
                if (aaa != bbb) {
                    return aaa > bbb?1:-1;
                }
                index++;
            }

            i++;
            j++;
        }
        return 0;
    }

    private String leadingZero(String s) {
        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index++) != '0') {
                return s.substring(index-1);
            }
        }

        return s;
    }

    private String validate(String s) {
        s = s.trim();
        if (s.startsWith(".")) {
            s = "0"+s;
        }

        if (s.endsWith(".")) {
            s = s+"0";
        }

        return s;
    }

    public static void main(String[] args) {
//        System.out.println(new CompareVersionNumbers().compareVersion(".1.", "0.1.000000.0"));
        System.out.println(new CompareVersionNumbers().compareVersion("4444371174137455", "5.168"));
    }
}
