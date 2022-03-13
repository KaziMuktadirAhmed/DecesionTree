package DecesionTree;

public class Wine {
    public double Alchol;
    public double MalicAcid;
    public double Ash;
    public double AlcalinityOfAsh;
    public double Magnesium;
    public double TotalPhenols;
    public double Flavanoids;
    public double NonflavanoidPhenols;
    public double Proanthocyanins;
    public double ColorIntensity;
    public double Hue;
    public double OD280_OD315_DilutedWines;
    public double Proline;

    public double get (int index) {
        switch (index){
            case 0:
                return this.Alchol;
            case 1:
                return this.MalicAcid;
            case 2:
                return this.Ash;
            case 3:
                return this.AlcalinityOfAsh;
            case 4:
                return this.Magnesium;
            case 5:
                return this.TotalPhenols;
            case 6:
                return this.Flavanoids;
            case 7:
                return this.NonflavanoidPhenols;
            case 8:
                return this.Proanthocyanins;
            case 9:
                return this.ColorIntensity;
            case 10:
                return this.Hue;
            case 11:
                return this.OD280_OD315_DilutedWines;
            case 12:
                return this.Proline;
            default:
                return -1;
        }
    }
}
