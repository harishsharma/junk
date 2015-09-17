package misc;

public class L {
    public static String removeSlashes(String uri) {
        if (uri.charAt(0) == '/') uri = uri.substring(1);
        if (uri.charAt(uri.length() - 1) == '/') uri = uri.substring(0, uri.length() - 1);
        return uri;
    }

    public static void main(String[] args) {
        System.out.println(removeSlashes("/a/a/a"));
        System.out.println(removeSlashes("/a/a/a/"));
        System.out.println(removeSlashes("a/a/a/"));
    }
}
