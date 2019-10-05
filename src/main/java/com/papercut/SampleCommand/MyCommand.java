package com.papercut.SampleCommand;
import picocli.CommandLine.Command;
import picocli.CommandLine;
import picocli.CommandLine.Parameters;
import java.util.Locale;

@picocli.CommandLine.Command(name="mycommand",subcommands = {
        MyCommand.Multiply.class
})
public class MyCommand implements java.util.concurrent.Callable {
    static public void main(String[] args) {
        Locale original = Locale.getDefault();
        System.out.println("LOCALE=" + original.getDisplayName());
        int exitCode = new CommandLine(new MyCommand()).execute(args);
    }
    @Override
    public Object call() throws Exception {
        System.out.println("running mycommand");

        return null;
    }

    @Command(name="doaashout")
    public int shout() {
        System.out.println("HI!");
        return 2;
    }
    int prod;
    @Command(name = "mult")
    void mult(@Parameters(paramLabel = "<operands>",arity = "1..*") int[] operands) {
        prod = 1;
        for (int factor: operands) {
            prod *= factor;
        }
        System.out.println("product of operands = " + prod);
    }
    @Command(name="mul")
    public static class Multiply implements java.util.concurrent.Callable {
        @picocli.CommandLine.Parameters(paramLabel = "operand1")
        int operand1;
        @picocli.CommandLine.Parameters(paramLabel = "operand2")
        int operand2;
        int result;

        @Override
        public Object call() throws Exception {
            result = operand1*operand2;
            System.out.println("result = " + result);
            return null;
        }
    }
    public int multiply( int arg1, int arg2) {
         int op1;
         return 1;
    }
}

