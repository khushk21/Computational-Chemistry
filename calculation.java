package isc.chem_project;
class calculation
{
    double masmol;
   //storing the elements and its respective atomic mass in two single dimension arrays.    
    static final String symbol[] = {"H","He","Li","Be","B","C","N","O","F","Ne","Na","Mg","Al","Si","P","S","Cl","Ar","K","Ca","Sc","Ti","V","Cr","Mn",
                                  "Fe","Co","Ni","Cu","Zn","Ga","Ge","As","Se","Br","Kr","Rb","Sr","Y","Zr","Nb","Mo","Tc","Ru","Rh","Pd","Ag","Cd","In",
                                  "Sn","Sb","Te","I","Xe","Cs","Ba","La","Ce","Pr","Nd","Pm","Sm","Eu","Gd","Tb","Dy","Ho","Er","Tm","Yb","Lu",
                                  "Hf","Ta","W","Re","Os","Ir","Pt","Au","Hg","Tl","Pb","Bi","Po","At","Rn","Fr","Ra","Ac","Th","Pa","U","Np","Pu",
                                  "Am","Cu","Bk","Cf","Es","Fm","Md","No","Lr","Rf","Db","Sg","Bh","Mt","Rg","Hs",};
    static final double ma[] = {1.0079,4.0026,6.941,9.0122,10.811,12.0107,14.0067,15.9994,18.9984,20.1797,22.9897,24.305,26.9815,
                                28.0855,30.9738,32.065,35.453,39.948,39.0983,40.078,44.955908,47.867,50.9415,51.9961,54.938044,
                                55.845,58.933194,58.6934,63.546,65.38,69.723,72.63,74.9216,78.971,79.904,83.798,85.4678,87.62,88.90584,
                                91.224,92.90637,95.95,97,101.07,102.9055,106.42,107.8682,112.414,114.818,118.71,121.76,127.6,126.9044,
                                131.293,132.9055,137.327,138.90547,140.116,140.90766,144.242,145,150.36,151.964,157.25,158.9254,162.5,
                                164.9303,167.259,168.93422,173.045,174.9668,178.49,180.94788,183.84,186.207,190.23,192.217,195.084,196.967,
                                200.592,204.38,207.2,208.9804,209,210,222,223,226,227,232.0377,231.03588,235.802891,237,244,243,247,247,251,252,
                                257,258,259,262,267,270,269,270,270};
                                
    calculation(int ed, String s[], double coeff[])
    {
        double massat[] = new double[ed];
        for (int a=0;a<ed;a++)
        {
            for (int i=0; i<symbol.length;i++)
            {
                if (s[a].equals(symbol[i]))
                {
                    massat[a]=ma[i];
                    break;
                }
            }
        }
        for (int a=0;a<ed;a++)
        {            
            if (massat[a]>0) 
            {
                masmol=masmol+massat[a]*coeff[a];
            }
            else
            {
                masmol=0;
                break;
            }
        }
    }

    double mass()
    {
        return masmol;
    }
}