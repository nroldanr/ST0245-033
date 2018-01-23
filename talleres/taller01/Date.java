
/**
 * Write a description of class Fechas here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Date
{
    private String name;
    private int day;
    private int month;
    private int year;
 Date(String name, int day, int month, int year){
     this.name = name;
     this.day = day;
     this.month = month;
     this.year = year;
    }
 boolean equals(int dia, int mes, int año){
     boolean iguales = false;
     if(day == dia){
         if(month == mes){
             if(year == año){
                 iguales = true;
                }
            }
        }
     return iguales; 
    }
 String pos(int dia, int mes, int año){
     String antes = "antes";
     String despues = "despues";
     String fn = "";
     if(año > year){
         fn = despues;
        }
     else if(mes > month){
         fn = despues;
        }
     else if(dia > day){
         fn = despues;
        }
     else if(day == dia){
         if(month == mes){
             if(year == año){
                 fn = "iguales";
                }
            }
        }
     else if(año < year){
         fn = antes;
        }
     else if(mes < month){
         fn = antes;
        }
     else if(dia < day){
         fn = antes;
        }  
        return fn;
    }   
}
