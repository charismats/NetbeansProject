/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paladin.calculator;

import java.util.Stack;
import java.util.Scanner;

/**
 *
 * @author charisma
 * @version 1.1
 * @since April, 2014
 */
public class ReversePolish {

    private String strEval;
    private String strRPN;
    Stack<Double> operand;

    private double result = 0;

    public ReversePolish(String text) {
        strEval = text;
        operand = new Stack<Double>();
        result = 0;
        strRPN = "";
    }

    public void RunAlgorithm() {
        strRPN = MakeRPN(strEval, false);
        System.out.println(strEval + " => RPN = " + strRPN);
        result = Evaluate(strRPN);
        System.out.println("Result = " + result);
    }

    public String MakeRPN(String text, boolean inside) {

        String strOperator1 = ""; //for addition and subtraction
        String strOperator2 = ""; //for multiplication and subtraction
        String retRPN = "";
        String insideRPN = "";
        int numOperand = 0;
        int numOperator = 0;
        boolean multExist = false;
        boolean divExist = false;
        //check if text is digit
        for (int i = 0; i < text.length();) {
            char c = text.charAt(i);
            String num = "";
            while (i < text.length() && (Character.isDigit(c) || Character.isAlphabetic((c)))) {
                num += c;
                i++;
                if (i > text.length() - 1) {
                    break;
                }
                c = text.charAt(i);
            }
            if (num != "") {
                retRPN += num + " ";
                numOperand++;
                num = "";
                if (i <= text.length() - 1 && text.charAt(i + 1) == '*') {
                    multExist = true;
                } else if (i <= text.length() - 1 && text.charAt(i + 1) == '/') {
                    divExist = true;
                }
            }
            if (Character.isWhitespace(c)) {
                i++;
            }
            if (isOperator(c)) {
                while( (i+1) < text.length() && text.charAt(i+1) == ' '){
                    i++;
                }
                i++;
                char a_c = text.charAt(i);
                if (a_c == '(') {
                    int idxKurungAkhir = text.lastIndexOf(")");
                    if (idxKurungAkhir == -1) {
                        System.out.println("Not valid expression");
                        System.exit(-1);
                    }
                    String sub = text.substring(i + 1, text.lastIndexOf(")"));
                    insideRPN = MakeRPN(sub, true);
                    i += (idxKurungAkhir - i + 2);
                }
                
                //i += 2;
                if (c == '*' || c == '/') {
                    strOperator2 += c + " ";

                    if (i <= text.length() - 1) {
                        char t_c = text.charAt(i);
                        while (i < text.length() && (Character.isDigit(t_c) || Character.isAlphabetic((t_c)))) {
                            num += t_c;
                            i++;
                            if (i > text.length() - 1) {
                                break;
                            }
                            t_c = text.charAt(i);
                        }
                        if (num != "") {
                            //check num is left or right operand
                            retRPN += num + " ";
                            numOperand++;
                            num = "";
                        }
                    }
                } else {
                    strOperator1 += c + " ";
                }
            } else if (c == '(') {
                int idxKurungAkhir = text.lastIndexOf(")");
                if (idxKurungAkhir == -1) {
                    System.out.println("Not valid expression");
                    System.exit(-1);
                }
                String sub = text.substring(i + 1, text.lastIndexOf(")"));
                insideRPN = MakeRPN(sub, true);
                i += (idxKurungAkhir - i + 2);
            } else if (c == ')') {
                i++;
            }
            //System.out.println("RPN = " + strRPN);

            if (insideRPN != "") {
                int[] operator_operand = getNumOperatorOperand(insideRPN);
                retRPN = retRPN + insideRPN;
                numOperator += operator_operand[0];
                numOperand += operator_operand[1];
                if (strOperator2 != "") {
                    retRPN += strOperator2;
                    numOperator++;
                    strOperator2 = "";
                }
                if (strOperator1 != "") {
                    retRPN += strOperator1;
                    numOperator++;
                    strOperator1 = "";
                }
                insideRPN = "";
            }
            if (numOperand - numOperator >= 2 && strOperator2 != "") {
                retRPN += strOperator2;
                if (strOperator2.indexOf('*') != -1) {
                    multExist = false;
                }
                if (strOperator2.indexOf('/') != -1) {
                    divExist = false;
                }
                strOperator2 = "";
                numOperator++;
            }
            if (numOperand - numOperator >= 2 && strOperator1 != "" && !multExist && !divExist) {
                //System.out.print("RPN = " + strRPN);
                retRPN += strOperator1;
                strOperator1 = "";
                numOperator++;
            }
        }
        return retRPN;
    }

    private int[] getNumOperatorOperand(String text) {
        int[] operator_operand = new int[2];
        Scanner sc = new Scanner(text);
        while (sc.hasNext()) {
            String next = sc.next();
            if (next.equals("*") || next.equals("/") || next.equals("+") || next.equals("-")) {
                operator_operand[0]++;
            } else {
                operator_operand[1]++;
            }
        }
        return operator_operand;
    }

    public double Evaluate(String text) {
        double res = 0;
        Scanner sc = new Scanner(text);
        String next;
        double n1, n2;
        while (sc.hasNext()) {
            next = sc.next();
            switch (next) {
                case "*":
                    n1 = operand.pop();
                    n2 = operand.pop();
                    operand.push(n1 * n2);
                    break;
                case "+":
                    n1 = operand.pop();
                    n2 = operand.pop();
                    operand.push(n1 + n2);
                    break;
                case "/":
                    n1 = operand.pop();
                    n2 = operand.pop();
                    operand.push(n2 / n1);
                    break;
                case "-":
                    n1 = operand.pop();
                    n2 = operand.pop();
                    operand.push(n2 - n1);
                    break;
                default:
                    operand.push(Double.parseDouble(next));
                    break;
            }
        }
        if (!operand.empty()) {
            res = operand.pop();
        }
        return res;
    }

    public boolean isOperator(char c) {
        if (c == '*' || c == '/' || c == '+' || c == '-' || c == '^') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String eval1 = "5 + (1 + 2 * 4) - 3";
        ReversePolish rpn1 = new ReversePolish(eval1);
        rpn1.RunAlgorithm();
        String eval2 = "5 + ((1 + 2) * 4) - 3";
        ReversePolish rpn2 = new ReversePolish(eval2);
        rpn2.RunAlgorithm();
        String eval3 = "8 * 2 / (3 - 4 + (2 * 1))";
        ReversePolish rpn3 = new ReversePolish(eval3);
        rpn3.RunAlgorithm();
        String eval4 = "8 * 2 / (3 - 4 + 2 * 1)";
        ReversePolish rpn4 = new ReversePolish(eval4);
        rpn4.RunAlgorithm();
        String eval5 = "3*3 + 2";
        ReversePolish rpn5 = new ReversePolish(eval5);
        rpn5.RunAlgorithm();
        String eval6 = "3 * (3 + 2)";
        ReversePolish rpn6 = new ReversePolish(eval6);
        rpn6.RunAlgorithm();
        String eval7 = "3* (3 + 2)";
        ReversePolish rpn7 = new ReversePolish(eval7);
        rpn7.RunAlgorithm();
        String eval8 = "3*(3+2)";
        ReversePolish rpn8 = new ReversePolish(eval8);
        rpn8.RunAlgorithm();
        String eval9 = "3*2/3+(3+2)";
        ReversePolish rpn9 = new ReversePolish(eval9);
        rpn9.RunAlgorithm();
        String eval10 = "3*2/3+( (3+2 *4))";
        ReversePolish rpn10 = new ReversePolish(eval10);
        rpn10.RunAlgorithm();
    }
}
