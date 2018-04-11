package com.paperscissorsstonegame;

/**
 * Created by user on 2018/4/11.
 */

public class Artificial_intelligence {
    private int AiPlay;

    public String getComputerChoice() {
        switch (AiPlay) {
            case 1:  return "剪刀";
            case 2:  return "石頭";
            default: return "布";
        }
    }

    public String whoWin(int UserPlay) {
        this.AiPlay = (int)(Math.random()*3 + 1);
        String winner;
        // 1 – 剪刀, 2 – 石頭, 3 – 布.
        if ((UserPlay == 1 && AiPlay == 3)||(UserPlay == 2 && AiPlay == 1)||(UserPlay == 3 && AiPlay == 2)) {
            winner = "恭喜，你贏了！";
        }
        else if (UserPlay == AiPlay){
            winner = "雙方平手！";
        }
        else {
            winner = "很可惜，你輸了！";
        }

        return winner;
    }
}
