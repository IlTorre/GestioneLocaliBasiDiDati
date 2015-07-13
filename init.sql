CREATE TABLE Utente (
	nTessera SERIAL,
	cf CHAR(16) UNIQUE NOT NULL,
	nome CHAR(25),
	cognome CHAR (25),
PRIMARY KEY (nTessera)
);

CREATE TABLE Studente (
	matr INTEGER,
	nTessera INTEGER UNIQUE NOT NULL,
PRIMARY KEY (matr),
FOREIGN KEY (nTessera) REFERENCES Utente (nTessera) ON DELETE CASCADE
);

CREATE TABLE Docente (
	nTessera INTEGER,
PRIMARY KEY (nTessera),
FOREIGN KEY (nTessera) REFERENCES Utente (nTessera) ON DELETE CASCADE
);

CREATE TABLE Tecnico (
nTessera INTEGER,
PRIMARY KEY (nTessera),
FOREIGN KEY (nTessera) REFERENCES Utente (nTessera) ON DELETE CASCADE
);

CREATE TABLE Locali (
	cod CHAR(5),
	nome VARCHAR(30),
	descrizione VARCHAR(300),
PRIMARY KEY(cod)
);

CREATE TABLE Riservato (
	cod CHAR(5),
PRIMARY KEY(cod),
FOREIGN KEY(cod) REFERENCES Locali (cod) ON DELETE CASCADE
);

CREATE TABLE Tracciato (
	cod CHAR(5),
PRIMARY KEY(cod),
FOREIGN KEY(cod) REFERENCES Locali (cod) ON DELETE CASCADE
);


CREATE TABLE NonTracciato (
	cod CHAR(5),
PRIMARY KEY(cod),
FOREIGN KEY(cod) REFERENCES Locali (cod) ON DELETE CASCADE
);

CREATE TABLE Laboratori (
	cod CHAR(5),
	operativo INTEGER UNIQUE NOT NULL,
	organizzativo INTEGER UNIQUE NOT NULL,
PRIMARY KEY (cod),
FOREIGN KEY (cod) REFERENCES Locali (cod) ON DELETE CASCADE,
FOREIGN KEY (operativo) REFERENCES Tecnico(nTessera) ON DELETE NO ACTION,
FOREIGN KEY (organizzativo) REFERENCES Docente (nTessera) ON DELETE NO ACTION
);

CREATE TABLE Tipo (
	tipo CHAR(4),
PRIMARY KEY (tipo)
);

CREATE TABLE Fasce (
	giorno SMALLINT CHECK (giorno>=1 and giorno<=7),
	orai TIME(0),
	oraf TIME(0) CHECK (orai<oraf),
PRIMARY KEY (giorno, orai, oraf)
);

CREATE TABLE Per (
	tipo CHAR(4),
giorno SMALLINT,
	orai TIME(0),
	oraf TIME(0),
PRIMARY KEY (tipo, giorno, orai, oraf),
FOREIGN KEY(tipo) REFERENCES Tipo (tipo) ON DELETE CASCADE,
FOREIGN KEY (giorno, orai, oraf) REFERENCES Fasce (giorno, orai, oraf) ON DELETE CASCADE
);

CREATE TABLE Permesso (
	cod CHAR(5),
	nTessera INTEGER,
	tipo CHAR(4),
PRIMARY KEY (cod, nTessera),
FOREIGN KEY (cod) REFERENCES Riservato (cod) ON DELETE CASCADE,
FOREIGN KEY (nTessera) REFERENCES Utente (nTessera) ON DELETE CASCADE,
FOREIGN KEY (tipo) REFERENCES Tipo (tipo) ON DELETE CASCADE
);

CREATE TABLE AccessoNegato (
	nTessera INTEGER,
	data DATE,
	ora TIME(4),
	cod CHAR(5),
PRIMARY KEY (nTessera, data, ora, cod),
FOREIGN KEY (nTessera) REFERENCES Utente (nTessera) ON DELETE CASCADE,
FOREIGN KEY (cod) REFERENCES Riservato (cod) ON DELETE CASCADE
);

CREATE TABLE TreAccNegati (
	nTessera INTEGER,
	data DATE,
	cod CHAR(5),
PRIMARY KEY (nTessera, data, cod),
FOREIGN KEY (nTessera) REFERENCES Utente (nTessera) ON DELETE CASCADE,
FOREIGN KEY (cod) REFERENCES Riservato (cod) ON DELETE CASCADE
);

CREATE TABLE nAccessi (
	cod CHAR(4),
	data DATE,
	n INTEGER,
PRIMARY KEY (cod, data),
FOREIGN KEY (cod) REFERENCES NonTracciato (cod) ON DELETE CASCADE
);

CREATE TABLE Accesso (
	ntessera INTEGER,
	data DATE,
	ora TIME(4),
	cod CHAR(5),
PRIMARY KEY (ntessera, ora, data), 
FOREIGN KEY (ntessera) REFERENCES Utente (ntessera) ON DELETE NO ACTION,
FOREIGN KEY (cod) REFERENCES Tracciato (cod) ON DELETE CASCADE
);
 
CREATE TABLE PostiDiLavoro (
	n SMALLINT,
	cod CHAR(4),
PRIMARY KEY (n, cod),
FOREIGN KEY (cod) REFERENCES Laboratori (cod) ON DELETE CASCADE
);

CREATE TABLE Prenotabili (
	n SMALLINT,
	cod CHAR(4),
PRIMARY KEY (n, cod),
FOREIGN KEY (cod, n) REFERENCES PostiDiLavoro (cod, n) ON DELETE CASCADE
);

CREATE TABLE conAutorizzazione (
	n SMALLINT,
	cod CHAR(4),
PRIMARY KEY (n, cod),
FOREIGN KEY (cod, n) REFERENCES PostiDiLavoro (cod, n) ON DELETE CASCADE
);

CREATE TABLE Libero (
	n SMALLINT,
	cod CHAR(4),
PRIMARY KEY (n, cod),
FOREIGN KEY (cod, n) REFERENCES PostiDiLavoro (cod, n) ON DELETE CASCADE
);

CREATE TABLE Disponibile (
	n SMALLINT,
	cod CHAR(4),
	matr INTEGER,
PRIMARY KEY (n, cod, matr),
FOREIGN KEY (cod, n) REFERENCES Libero (cod, n) ON DELETE CASCADE,
FOREIGN KEY (matr) REFERENCES Studente (matr) ON DELETE CASCADE
);

CREATE TABLE Prenotazione (
	n SMALLINT,
	cod CHAR(4),
	data DATE,
	orai TIME(0),
	oraf TIME(0) CHECK(orai<oraf),
	nTessera INTEGER NOT NULL,
PRIMARY KEY (n, cod, data, orai, oraf),
FOREIGN KEY (n, cod) REFERENCES Prenotabili (n, cod) ON DELETE CASCADE,
FOREIGN KEY (nTessera) REFERENCES Utente (nTessera) ON DELETE CASCADE
);

CREATE TABLE Assegnati (
	mese SMALLINT CHECK(mese>=1 and mese<=12),
	n SMALLINT,
	cod CHAR(4),
	matr INT,
	nTessera INT,
PRIMARY KEY (mese, n, cod),
FOREIGN KEY (n, cod) REFERENCES conAutorizzazione (n, cod) ON DELETE CASCADE,
FOREIGN KEY (matr) REFERENCES Studente (matr) ON DELETE CASCADE,
FOREIGN KEY (nTessera) REFERENCES Docente (nTessera) ON DELETE CASCADE
);

CREATE TABLE Risorse (
	cod CHAR(6),
	descrizione VARCHAR(30),
PRIMARY KEY (cod)
);

CREATE TABLE UnitaCalcolo (
	cod CHAR(6),
PRIMARY KEY (cod),
FOREIGN KEY (cod) REFERENCES Risorse (cod) ON DELETE CASCADE
);

CREATE TABLE Privilegi (
	codp CHAR(6),
	cod CHAR(6) NOT NULL,
	tipo CHAR (30) NOT NULL,
PRIMARY KEY (codp),
FOREIGN KEY (cod) REFERENCES Risorse (cod) ON DELETE CASCADE,
UNIQUE (cod, tipo)
);

CREATE TABLE CorsoLaurea (
	codl CHAR(4),
	nome VARCHAR(30),
PRIMARY KEY (codl)
);

CREATE TABLE Gruppo (
	codl CHAR(4),
	anno SMALLINT CHECK (anno>1700),
PRIMARY KEY (codl, anno),
FOREIGN KEY (codl) REFERENCES CorsoLaurea (codl) ON DELETE CASCADE
);

CREATE TABLE Ha (
	Codl CHAR(4),
	anno SMALLINT,
	codp CHAR(6),
PRIMARY KEY (codl, anno, codp),
FOREIGN KEY (codl, anno) REFERENCES Gruppo (codl, anno) ON DELETE CASCADE,
FOREIGN KEY (codp) REFERENCES Privilegi (codp) ON DELETE CASCADE
);

CREATE TABLE Account (
	matr INTEGER NOT NULL,
	codl CHAR(4) NOT NULL,
	anno SMALLINT NOT NULL,
	utente VARCHAR(20),
	password CHAR(128),
shell CHAR(3),
PRIMARY KEY (utente),
FOREIGN KEY (matr) REFERENCES Studente (matr) ON DELETE CASCADE,
FOREIGN KEY (codl, anno) REFERENCES Gruppo (codl, anno) ON DELETE CASCADE,
UNIQUE (matr, codl, anno)
);
CREATE TABLE App (
	coda CHAR(5),
	descrizione VARCHAR(30),
PRIMARY KEY (coda)
);

CREATE TABLE Utilizzate (
	utente VARCHAR(20),
	coda CHAR(5),
PRIMARY KEY (utente, coda),
FOREIGN KEY (utente) REFERENCES Account (utente) ON DELETE CASCADE,
FOREIGN KEY (coda) REFERENCES App (coda) ON DELETE CASCADE
);

CREATE TABLE Hanno (
	utente VARCHAR(20),
	cod CHAR(6),
PRIMARY KEY (utente, cod),
FOREIGN KEY (utente) REFERENCES Account (utente) ON DELETE CASCADE,
FOREIGN KEY (cod) REFERENCES UnitaCalcolo (cod) ON DELETE CASCADE
);

CREATE FUNCTION check_negati() RETURNS trigger AS $check_negati$
 BEGIN
IF (SELECT COUNT(*) FROM accessonegato WHERE cod=new.cod and ntessera=new.ntessera and data=new.data) =3 THEN
INSERT INTO "treaccnegati" (ntessera,cod,data) VALUES (new.ntessera, new.cod, new.data);
END IF;
RETURN NEW;
END;
$check_negati$ LANGUAGE plpgsql;
CREATE TRIGGER GESTIONE_NEGATI
AFTER INSERT OR UPDATE ON accessonegato
FOR EACH ROW EXECUTE PROCEDURE check_negati();

CREATE FUNCTION check_categoria() RETURNS trigger AS $check_categoria$
 BEGIN
IF (SELECT COUNT(*) FROM ((SELECT ntessera FROM studente) UNION (SELECT ntessera FROM docente) UNION (SELECT ntessera FROM tecnico)) AS tot WHERE tot.ntessera=new.ntessera ) >0 THEN
RAISE EXCEPTION 'Utente già categorizzato';
END IF;
RETURN NEW;
END;
$check_categoria$ LANGUAGE plpgsql;

CREATE TRIGGER GESTIONE_studente
BEFORE INSERT OR UPDATE ON studente
FOR EACH ROW EXECUTE PROCEDURE check_categoria();

CREATE TRIGGER GESTIONE_tecnico
BEFORE INSERT OR UPDATE ON tecnico
FOR EACH ROW EXECUTE PROCEDURE check_categoria();

CREATE TRIGGER GESTIONE_docente
BEFORE INSERT OR UPDATE ON docente
FOR EACH ROW EXECUTE PROCEDURE check_categoria();




CREATE FUNCTION check_tipo_posto() RETURNS trigger AS $check_tipo_posto$
 BEGIN
IF (SELECT COUNT(*) FROM ((SELECT n, cod FROM prenotabili) UNION (SELECT n, cod FROM conautorizzazione) UNION (SELECT n, cod FROM libero)) AS tot WHERE tot.n=new.n and tot.cod=new.cod ) >0 THEN
RAISE EXCEPTION 'Posto già categorizzato';
END IF;
RETURN NEW;
END;
$check_tipo_posto$ LANGUAGE plpgsql;

CREATE TRIGGER GESTIONE_prenotabili
BEFORE INSERT OR UPDATE ON prenotabili
FOR EACH ROW EXECUTE PROCEDURE check_tipo_posto();

CREATE TRIGGER GESTIONE_conautorizzazione
BEFORE INSERT OR UPDATE ON conautorizzazione
FOR EACH ROW EXECUTE PROCEDURE check_tipo_posto();

CREATE TRIGGER GESTIONE_libero
BEFORE INSERT OR UPDATE ON libero
FOR EACH ROW EXECUTE PROCEDURE check_tipo_posto();

CREATE FUNCTION check_prenotazione() RETURNS trigger AS $check_prenotazione$
 BEGIN
IF ((SELECT COUNT(*) FROM Studente WHERE ntessera=new.ntessera)=1 AND (SELECT COUNT(*) FROM Prenotazione WHERE ntessera=new.ntessera AND data=new.data AND oraf=new.oraf AND orai=new.orai)>=1) THEN
RAISE EXCEPTION 'Uno studente non può prenotare più posti nella stessa fascia.';
END IF;
RETURN NEW;
END;
$check_prenotazione$ LANGUAGE plpgsql;

CREATE TRIGGER GESTIONE_prenotazione
BEFORE INSERT OR UPDATE ON prenotazione
FOR EACH ROW EXECUTE PROCEDURE check_prenotazione ();

INSERT INTO "utente" (CF, nome, cognome)
VALUES 
('TRRMRC92C14H223Q','Marco','Torreggiani'),
('SPNDVD93T11F240N','Davide','Sapienza'),
('VZZLRT91B08B819X','Alberto','Vezzani'),
('PSDFKB2132SDF5GX','Pippo','Piri'),
('RCCMRT90K256Z85W','Riccardo','Martoglia'),
('LNCMRA80B12C218R','Mauro','Leoncini'),
('RSSNTN80F21H223Q','Antonia','Rossi'),
('NDRRSL80B12C218R','Rosalba','Andreotti');

INSERT INTO "studente" (nTessera,matr)
VALUES
(1,70297),
(2,70649),
(3,73272),
(4,55555);

INSERT INTO "docente"
VALUES
(5),
(6),
(7);

INSERT INTO "tecnico"
VALUES
(8);

INSERT INTO "locali"(cod, nome, descrizione)
VALUES
('L1','Lab Base','Laboratorio di informatica'),
('L2','Biblioteca','BSI'),
('L3','Aula Studio','Riservata a una categoria di studenti'),
('L4','BOX','Box studio'),
('L5','Sgabuzzino','contiene detersivi');

INSERT INTO "riservato"
VALUES ('L3');

INSERT INTO "tracciato"
VALUES ('L4');

INSERT INTO "nontracciato"
VALUES ('L2');

INSERT INTO "laboratori"
VALUES ('L1',8,5);

INSERT INTO "tipo"
VALUES ('T001'),('T002'),('T003'),('T004');

INSERT INTO "fasce" (giorno,orai,oraf)
VALUES 
(1,'09:00','11:00'),
(1,'12:00','13:00'),
(2,'11:00','13:00'),
(3,'11:00','13:00'),
(4,'11:00','13:00'),
(5,'14:00','15:00'),
(1,'18:00','19:00'),
(2,'9:00','13:00'),
(3,'16:00','18:00'),
(4,'9:00','13:00'),
(5,'14:00','15:30');

INSERT INTO "per" (tipo,giorno,orai,oraf)
VALUES 
('T001',1,'09:00','11:00'),
('T001',1,'12:00','13:00'),
('T003',2,'11:00','13:00'),
('T002',3,'11:00','13:00'),
('T004',4,'11:00','13:00');

INSERT INTO "permesso" (cod,ntessera,tipo)
VALUES 
('L3',1,'T001'),
('L3',2,'T003'),
('L3',3,'T002');

INSERT INTO "postidilavoro" (n,cod)
VALUES 
(1,'L1'),(2,'L1'),(3,'L1'),(4,'L1'),(5,'L1'),(6,'L1'),(7,'L1'),(8,'L1'),(9,'L1'),(10,'L1'),(11,'L1'),(12,'L1'),(13,'L1'),
(14,'L1'),(15,'L1'),(16,'L1'),(17,'L1'),(18,'L1'),(19,'L1'),(20,'L1');

INSERT INTO "prenotabili" (n,cod)
VALUES 
(1,'L1'),(2,'L1'),(3,'L1'),(4,'L1'),(5,'L1');

INSERT INTO "conautorizzazione" (n,cod)
VALUES 
(15,'L1'),
(16,'L1'),
(17,'L1'),
(18,'L1'),
(19,'L1'),
(20,'L1');

INSERT INTO "libero" (n,cod)
VALUES 
(6,'L1'),(7,'L1'),(8,'L1'),(9,'L1'),(10,'L1'),(11,'L1'),(12,'L1'),(13,'L1'),(14,'L1');

INSERT INTO "risorse" (cod, descrizione)
VALUES 
('R00001','stampante'),
('R00002','stampante'),
('R00003','stampante'),
('R00004','proiettore'),
('R00005','computer'),
('R00006','computer'),
('R00007','computer'),
('R00008','computer'),
('R00009','computer'),
('R00010','computer'),
('R00011','condizionatore');

INSERT INTO "unitacalcolo"
VALUES 
('R00005'),('R00006'),('R00007'),('R00008'),('R00009'),('R00010');

INSERT INTO "privilegi" (codp,cod,tipo)
VALUES 
('PRIV01','R00001','stampaFree'),
('PRIV02','R00005','admin'),
('PRIV03','R00004','telecomando');

INSERT INTO "corsolaurea" (codl,nome)
VALUES 
('INF1','Informatica'),
('MAT1','Matematica'),
('MED1','Medicina');


INSERT INTO "gruppo" (codl,anno)
VALUES
('INF1',2010),
('MAT1',2010),
('MED1',2010),
('INF1',2011),
('MAT1',2011),
('MED1',2011),
('INF1',2012),
('MAT1',2012),
('MED1',2012);

INSERT INTO "account" (matr, codl, anno, utente, password)
VALUES 
(70297, 'INF1', 2010, 'torre', 'pass1'),
(70649, 'INF1', 2011, 'sappi', 'pass2'),
(73272, 'MAT1', 2011, 'albi', 'pass3');

INSERT INTO "app" (coda,descrizione)
VALUES
('APP01','Matlab'),
('APP02','Postgres'),
('APP03','Netlogo'),
('APP04','g++');
