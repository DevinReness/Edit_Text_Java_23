package doublle.linklist;

import java.util.Scanner;

public class LinkedList{

    class data {
    String huruf;
    data next;
    data prev;
        public void insert(String huruf){
            this.huruf=huruf;
        }
        public String getHuruf(){
         return this.huruf;
        }
    
}
    data head=null,tail=null,themp,baru,cetak;
    
    public void add(){
        System.out.print("Masukan 1 charakter\nAdd  :");
        Scanner input = new Scanner (System.in);
        String huruf;
        huruf = input.next();
        baru = new data();
        baru.insert(huruf);
        
        baru.next=null;
    
        if (head==null)
    {
        head=baru;
        tail=baru;
        themp=head;
        head.next=null;
        head.prev=null;
    }
    else if (themp.next==null)
    {
        themp.next=baru;
        tail=baru;
        baru.prev=themp;
        themp=baru;
        tail.next=null;
    }
    else if (themp.prev==null)
    {
        baru.next=themp.next;
        baru.prev=themp;
        baru.next.prev=baru;
        themp.next=baru;
        themp=themp.next;
    }
    else
    {
        baru.next = themp.next;
        baru.prev = themp;
        themp.next=baru;
        baru.next.prev=baru;
        themp=themp.next;
    }
        
        System.out.println("");
    }
    
    
    void del(){
        if(themp==head&&themp==tail)
   {
       themp=null;
       head=null;
       tail=null;
       themp=null;
   }
   else if(themp==head)
   {
       themp=themp.next;
       themp.prev=null;
       head=null;
       head=themp;
   }
   else if(themp==tail)
   {
       themp=themp.prev;
       themp.next=null;
       tail=null;
       tail=themp;
   }
   else
   {
       baru=themp.next;
       themp=themp.prev;
       themp.next=baru;
       baru.prev=null;
       baru.prev=themp;
   }
        System.out.print("\nData Berhasil di hapus...");
        System.out.print("\ntekan apa saja untuk lanjut...");
        Scanner pause = new Scanner (System.in);
        pause.nextLine();
    }
    
    void Sleft()
    {
        if(themp.prev==null)
    {
        System.out.print("pointer sudah paling kiri");
        
    }
    else
    {
        System.out.print("pointer tergeser ke kiri");
        themp=themp.prev;
    }
        System.out.print("\ntekan apa saja untuk lanjut...");
        Scanner pause = new Scanner (System.in);
        pause.nextLine();
    }
    
    void Sright()
    {
        if(themp.next==null)
    {
        System.out.print("pointer sudah paling kanan");
    }
    else
    {
        System.out.print("pointer tergeser ke kanan");
        themp=themp.next;
    }
        System.out.print("\ntekan apa saja untuk lanjut...");
        Scanner pause = new Scanner (System.in);
        pause.nextLine();
    }
    
    void print()
    {
        if(head!=null)
        {
            cetak=head;
            while(cetak!=null)
            {
                System.out.print(cetak.getHuruf());
                cetak=cetak.next;
            }
        }
        else
        {
            System.out.print("\n(kosong)\n");
        }
        System.out.print("\ntekan apa saja untuk lanjut...");
        Scanner pause = new Scanner (System.in);
        pause.nextLine();
    }
    
     public static void main(String[] args){
        LinkedList akses = new LinkedList();
        int z,v,pilih;
        System.out.println("\t\t|PROGRAM EDIT TEXT|");
        System.out.println("\t\t|_________________|\n\n");
        System.out.print("input banyak perulagan :");
        Scanner input = new Scanner (System.in);
        z = input.nextInt();
        for(v=0;v<z;v++)
        {
            System.out.print("ke-"+(v+1)+"\nMenu\t:\n");
            System.out.print("1) Print\n2) Add data\n3) Del data\n4) S-right\n5) S-left\n");
            System.out.print("Pilihan :");
            Scanner pil = new Scanner (System.in);
            pilih = pil.nextInt();
            switch(pilih)
            {
                case 1:akses.print();
                break;
                case 2:akses.add();
                break;
                case 3:akses.del();
                break;
                case 4:akses.Sright();
                break;
                case 5:akses.Sleft();
                break;
                default: System.exit(0);
            }
        }
    }
}
