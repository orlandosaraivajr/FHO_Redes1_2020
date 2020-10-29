#include <stdio.h>

int main ()
{
   FILE * pFile;
   int n;
   char name [100];

   pFile = fopen ("novo_arquivo.txt","w");
   for (n=0 ; n<3 ; n++)
   {
     puts ("Digite seu nome: ");
     gets (name);
     fprintf (pFile, "Nome %d [%-10.10s]\n",n+1,name);
   }
   fclose (pFile);

   return 0;
}
