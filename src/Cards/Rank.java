package Cards;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lbv001
 */
public enum Rank {
    ACE(14), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(
            9), TEN(10), J(11), Q(12), K(13);
    private int rank;

    private Rank(int rank) {
        this.rank = rank;
    }

    public int getValue() {
        return rank;
    }

}