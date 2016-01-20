package misc;

import java.io.ByteArrayInputStream;
import java.util.List;

import com.googlecode.jslint4java.Issue;
import com.googlecode.jslint4java.JSLint;
import com.googlecode.jslint4java.JSLintBuilder;
import com.googlecode.jslint4java.Option;

import org.w3c.tidy.Tidy;

/**
 * 
 * @author harish.sharma
 *
 */
public class Lint {
    public static void main(String[] args) {
        JSLint lint = new JSLintBuilder().fromDefault();
        lint.addOption(Option.BROWSER);
        List<Issue> issues = lint.lint("-", "window.alert(3);").getIssues();
        System.out.println(issues.size());


        Tidy tidy = new Tidy();
        tidy.parse(new ByteArrayInputStream("<html></html>".getBytes()), System.out);
        System.out.println(tidy.getParseErrors());
    }
}
