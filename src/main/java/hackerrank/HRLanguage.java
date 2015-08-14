package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/hackerrank-language
 * 
 * @author harish.sharma
 *
 */
public class HRLanguage {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] data = "C:CPP:JAVA:PYTHON:PERL:PHP:RUBY:CSHARP:HASKELL:CLOJURE:BASH:SCALA:ERLANG:CLISP:LUA:BRAINFUCK:JAVASCRIPT:GO:D:OCAML:R:PASCAL:SBCL:DART:GROOVY:OBJECTIVEC"
                .split(":");
        Set<String> langs = new HashSet<>();
        for (String a : data) {
            langs.add(a);
        }

        for (int i = 0; i < n; i++) {
            String lan = br.readLine().split(" ")[1];
            if (langs.contains(lan))
                System.out.println("VALID");
            else
                System.out.println("INVALID");
        }
        br.close();
    }
}
