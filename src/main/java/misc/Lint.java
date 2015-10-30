package misc;

import java.util.List;

import com.googlecode.jslint4java.Issue;
import com.googlecode.jslint4java.JSLint;
import com.googlecode.jslint4java.JSLintBuilder;

/**
 * 
 * @author harish.sharma
 *
 */
public class Lint {
    public static void main(String[] args) {
        JSLint lint = new JSLintBuilder().fromDefault();
        List<Issue> issues = lint.lint("-", "var x = 5;").getIssues();
        System.out.println(issues.size());
    }
}
