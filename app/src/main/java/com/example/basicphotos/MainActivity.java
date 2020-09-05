package com.example.basicphotos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import com.example.basicphotos.chess.Chessboard;
import com.example.basicphotos.chess.Square;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random r = new Random();
    static Chessboard c = new Chessboard();
    static boolean stalemate=false;
    static boolean check=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int resID = getResources().getIdentifier("AI", "id", getPackageName());
        char[] chessRows = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        char[] chessCols = {'1', '2', '3', '4', '5', '6', '7', '8'};
        boolean color=false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Square s=Chessboard.board[i][j];
                int idsq = getResources().getIdentifier(s.square_str, "id", getPackageName());
                View sq = findViewById(idsq);
                sq.setAlpha(0);
            }
        }
    }
    /*public List<> allPossibleMoves(){
        ArrayList<Move> moves=new ArrayList<Move>();
        for(piece A:pieces){
            List<Move> temp=A.possibleMoves();
            for(Move b:temp){
                moves.add(b);
            }
        }
        int i=Math().random()*
        r.nextInt(moves.length);
    }*/
    public void AImove(View v) {
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Hello", Toast.LENGTH_LONG).show();
        System.out.println("hello");
    }
}
