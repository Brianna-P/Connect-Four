import java.util.*; 
import java.math.*;

public class ConnectFourGame {
   public static void main(String[] args) {
   	   int numYellowTokens = 21;
   	   int numRedTokens = 21;
   	   
   	   System.out.println("Welcome to Connect Four! Your tokens will be red.");
   	   
   	   Scanner scnr = new Scanner(System.in);
   	   int[] counter = new int[7];
   	   int moveNum = 0;
   	   
   	   String[][] board = setUpBoard();
   	   
   	   while(gameIsNotOver(board, numYellowTokens + numRedTokens)) {
   	   	   printBoard(board);
   	   	   int move = getUserInput(scnr);
   	   	   if(isLegal(board, move, counter)) {
   	   	   	   updateBoard(board, move, counter, moveNum);
   	   	   	   ++moveNum;
   	   	   	   --numRedTokens;
   	   	   	   if (isWinner(board)) {
   	   	   	   	   printBoard(board);
   	   	   	   	   System.out.println("You won!");
   	   	   	   	   break;
   	   	   	   }
   	   	   	   System.out.println("You have " + numRedTokens + " tokens left.");
   	   	   } 
   	   	   else {
   	   	   	   System.out.println("That is not a legal move. Try again.");
   	   	   	   continue;
   	   	   }
   	   	   makeComputerMove(board, counter, moveNum); 
   	   	   ++moveNum;
   	   	   --numYellowTokens;
   	   	   if (isWinner(board)) {
   	   	   	   	   printBoard(board);
   	   	   	   	   System.out.println("The computer won!");
   	   	   	   	   break;
   	   	   	   }
   	   	   System.out.println("Opponent has " + numYellowTokens + " tokens left.");
   	   }
   	   
   	   System.out.println("The game is over!");
   }
   
   public static String[][] setUpBoard() {
   	   String[][] board = new String [6][7];
   	   
   	   for (int i = 0; i < board.length; ++i) {
   	   	   for (int j = 0; j < board[i].length; ++j) { 
   	   	   	   board[i][j] = "( )";
   	   	   }
   	   }
   	   
   	   return board;
   }
   
   public static void printBoard(String[][] board) {
   	   int numRedTokens = 21;
   	   int numYellowTokens = 21;
   	  
   	   System.out.println(" 0  1  2  3  4  5  6 ");
   	   System.out.println("---------------------");
   	   for (int i = board.length - 1; i >= 0; --i) {
      	  for (int j = 0; j < board[i].length; ++j) { 
      	  	  System.out.print(board[i][j]);
      	  }
      	  System.out.println();
       }
       
       System.out.println("---------------------");
   }
    
   public static boolean gameIsNotOver(String[][] board, int numTokens) {
   	   if(numTokens < 1) {
   	   	   return false;
   	   }
   	   else {
   	   	   return true;
   	   }
   }
   
   public static boolean isWinner(String[][] board) {
   	   //ACROSS RED
   	   for (int i = 0; i < board.length; ++i) {
   	   	   for (int j = 0; j < board[i].length-3; ++j) { 
   	   	   	   if ((board[i][j].equals("(R)")) && (board[i][j + 1].equals("(R)")) &&
   	   	   	   (board[i][j + 2].equals("(R)")) && (board[i][j + 3].equals("(R)"))) {
   	   	   	   return true;
   	   	   	   }
   	   	   }
   	   }
   	   //DOWN RED
   	   for (int i = 0; i < board.length - 3; ++i) {
   	   	   for (int j = 0; j < board[i].length; ++j) { 
   	   	   	   if ((board[i][j].equals("(R)")) && (board[i + 1][j].equals("(R)")) &&
   	   	   	   (board[i + 2][j].equals("(R)")) && (board[i + 3][j].equals("(R)"))) {
   	   	   	   return true;
   	   		   }
   	   	   }
   	   }
   	   //DIAGONAL FORWARDS RED
   	   for (int i = 3; i < board.length; ++i) {
   	   	   for (int j = 0; j < board[i].length - 3; ++j) { 
   	   	   	   if ((board[i][j].equals("(R)")) && (board[i - 1][j + 1].equals("(R)")) &&
   	   	   	   (board[i - 2][j + 2].equals("(R)")) && (board[i - 3][j + 3].equals("(R)"))) {
   	   	   	   return true;
   	   		   }
   	   	   }
   	   }
   	   //DIAGONAL BACKWARDS RED
   	   for (int i = 0; i < board.length - 3; ++i) {
   	   	   for (int j = 0; j < board[i].length - 3; ++j) { 
   	   	   	   if ((board[i][j].equals("(R)")) && (board[i + 1][j + 1].equals("(R)")) &&
   	   	   	   (board[i + 2][j + 2].equals("(R)")) && (board[i + 3][j + 3].equals("(R)"))) {
   	   	   	   return true;
   	   		   }
   	   	   }
   	   }
   	   
   	   //ACROSS YELLOW
   	   for (int i = 0; i < board.length; ++i) {
   	   	   for (int j = 0; j < board[i].length-3; ++j) { 
   	   	   	   if ((board[i][j].equals("(Y)")) && (board[i][j + 1].equals("(Y)")) &&
   	   	   	   (board[i][j + 2].equals("(Y)")) && (board[i][j + 3].equals("(Y)"))) {
   	   	   	   return true;
   	   	   	   }
   	   	   }
   	   }
   	   //DOWN YELLOW
   	   for (int i = 0; i < board.length - 3; ++i) {
   	   	   for (int j = 0; j < board[i].length; ++j) { 
   	   	   	   if ((board[i][j].equals("(Y)")) && (board[i + 1][j].equals("(Y)")) &&
   	   	   	   (board[i + 2][j].equals("(Y)")) && (board[i + 3][j].equals("(Y)"))) {
   	   	   	   return true;
   	   		   }
   	   	   }
   	   }
   	   //DIAGONAL FORWARDS YELLOW
   	   for (int i = 3; i < board.length; ++i) {
   	   	   for (int j = 0; j < board[i].length - 3; ++j) { 
   	   	   	   if ((board[i][j].equals("(Y)")) && (board[i - 1][j + 1].equals("(Y)")) &&
   	   	   	   (board[i - 2][j + 2].equals("(Y)")) && (board[i - 3][j + 3].equals("(Y)"))) {
   	   	   	   return true;
   	   		   }
   	   	   }
   	   }
   	   //DIAGONAL BACKWARDS YELLOW
   	   for (int i = 0; i < board.length - 3; ++i) {
   	   	   for (int j = 0; j < board[i].length - 3; ++j) { 
   	   	   	   if ((board[i][j].equals("(Y)")) && (board[i + 1][j + 1].equals("(Y)")) &&
   	   	   	   (board[i + 2][j + 2].equals("(Y)")) && (board[i + 3][j + 3].equals("(Y)"))) {
   	   	   	   return true;
   	   		   }
   	   	   }
   	   }
   	   return false;
   }
   
   public static int getUserInput(Scanner scnr) {
   	   System.out.println("Enter move in format <col>");
   	   int retVal = scnr.nextInt();
   	  
   	   return retVal;
   }
   
   public static boolean isLegal(String board[][], int move, int[] counter) {
   	  boolean isLegal = true;
   	   
   	   if ((move < 0) || (move > 6) || (counter[move] == 6)) {
   	   	   isLegal = false;

   	   }

   	   return isLegal;
   }

   public static void updateBoard(String[][] board, int move, int[] counter, int moveNum) {
   	   for (int i = 0; i < board.length; ++i) {
   	   	   if (board[i][move].equals("( )")) {
   	   	   	   if(moveNum%2 == 0) {
   	   	   	   board[i][move] = "(R)";
   	   	   	   counter[move] = counter[move] + 1;
   	   	   	   break;
   	   	   	   }
   	   	   	   else {
   	   	   	   	   board[i][move] = "(Y)";
   	   	   	   	   counter[move] = counter[move] + 1;
   	   	   	   	   break;
   	   	   	   }
   	   	   }
   	   }
   }
   
   public static void makeComputerMove(String[][] board, int[]counter, int moveNum) { 
   	   int compMove = 0;
   	   boolean x = false;
   	   
   	   while(x != true) {
   	   	   Random randNum = new Random();
   	   	   int y = randNum.nextInt(7);
   	   	   if (isLegal(board, compMove, counter)) {
   	   	   	   compMove = y;
   	   	   	   updateBoard(board, compMove, counter, moveNum);
   	   	   	   System.out.println("The computer's move is "  + compMove);
   	   	   	   x = true;
   	   	   }
   	   	   else {
   	   	   	   continue;
   	   	   }
   	   }
   }
}
