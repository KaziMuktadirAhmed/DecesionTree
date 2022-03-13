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

    public void set(int index, double value){
        switch (index) {
            case 1:
                this.Alchol = value;
                break;
            case 2:
                this.MalicAcid = value;
                break;
            case 3:
                this.Ash = value;
                break;
            case 4:
                this.AlcalinityOfAsh = value;
                break;
            case 5:
                this.Magnesium = value;
                break;
            case 6:
                this.TotalPhenols = value;
                break;
            case 7:
                this.Flavanoids = value;
                break;
            case 8:
                this.NonflavanoidPhenols = value;
                break;
            case 9:
                this.Proanthocyanins = value;
                break;
            case 10:
                this.ColorIntensity = value;
                break;
            case 11:
                this.Hue = value;
                break;
            case 12:
                this.OD280_OD315_DilutedWines = value;
                break;
            case 13:
                this.Proline = value;
                break;
            default:
                System.out.println("Wrong input");
        }
    }

    public double get(int index) {
        switch (index){
            case 1:
                return this.Alchol;
            case 2:
                return this.MalicAcid;
            case 3:
                return this.Ash;
            case 4:
                return this.AlcalinityOfAsh;
            case 5:
                return this.Magnesium;
            case 6:
                return this.TotalPhenols;
            case 7:
                return this.Flavanoids;
            case 8:
                return this.NonflavanoidPhenols;
            case 9:
                return this.Proanthocyanins;
            case 10:
                return this.ColorIntensity;
            case 11:
                return this.Hue;
            case 12:
                return this.OD280_OD315_DilutedWines;
            case 13:
                return this.Proline;
            default:
                return -1;
        }
    }
}
