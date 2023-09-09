public record Card(int rank, int suit) {

    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder();

        switch (this.suit) {
            case 0 -> temp.append("Kreuz ");
            case 1 -> temp.append("Karo ");
            case 2 -> temp.append("Herz ");
            case 3 -> temp.append("Pik ");
        }

        switch (this.rank) {
            case 11 -> temp.append("Bube");
            case 12 -> temp.append("Dame");
            case 13 -> temp.append("König");
            case 14 -> temp.append("Ass");
            default -> temp.append(this.rank);
        }

        return temp.toString();
    }


}
