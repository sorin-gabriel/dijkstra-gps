Detalii importante legate de implementare:
- Am optat pentru o coada de prioritate scrisa de mine care foloseste
o lista inlantuita. Fiecare nod primeste o prioritate in functie de costul
unui drum de la sursa pana la nodul respectiv

- Clasele 'Bicycle', 'Car', 'Motorcycle', 'Truck' extind clasa abstracta
'Vehicle' conform proprietatilor specifice fiecarui tip de vehicul

- Clasa 'WazeMap' extinde clasa abstracta 'MapGraph' si implementeaza
metodele addStreet, addRestriction si drive

- Clasa 'Main' este punctul de intrare in program si se ocupa de
deschiderea, citirea, scrierea si inchiderea fisierelor. In clasa 'Main'
se foloseste un obiect de tip 'WazeMap', implementarea algoritmului Dijkstra
fiind abstractizata in spatele acestui obiect, care ofera doar metodele
mentionate mai sus
