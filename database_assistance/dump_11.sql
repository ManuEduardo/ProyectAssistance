--
-- PostgreSQL database cluster dump
--

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Drop databases (except postgres and template1)
--

DROP DATABASE "BDAssistance";




--
-- Drop roles
--

DROP ROLE root;


--
-- Roles
--

CREATE ROLE root;
ALTER ROLE root WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION BYPASSRLS PASSWORD 'SCRAM-SHA-256$4096:WVfF4dxC6GWyGiv6F4zcvw==$3M1WPDusrHf4Ri9okVFtmiHLQCQnAf0aDBxIK5WVKks=:cfRa4c9LIMOH2OITKIPlvkFPj9mfkdRJAmcITWlzyN0=';






--
-- Databases
--

--
-- Database "template1" dump
--

--
-- PostgreSQL database dump
--

-- Dumped from database version 14.6 (Debian 14.6-1.pgdg110+1)
-- Dumped by pg_dump version 14.6 (Debian 14.6-1.pgdg110+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

UPDATE pg_catalog.pg_database SET datistemplate = false WHERE datname = 'template1';
DROP DATABASE template1;
--
-- Name: template1; Type: DATABASE; Schema: -; Owner: root
--

CREATE DATABASE template1 WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'en_US.utf8';


ALTER DATABASE template1 OWNER TO root;

\connect template1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: DATABASE template1; Type: COMMENT; Schema: -; Owner: root
--

COMMENT ON DATABASE template1 IS 'default template for new databases';


--
-- Name: template1; Type: DATABASE PROPERTIES; Schema: -; Owner: root
--

ALTER DATABASE template1 IS_TEMPLATE = true;


\connect template1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: DATABASE template1; Type: ACL; Schema: -; Owner: root
--

REVOKE CONNECT,TEMPORARY ON DATABASE template1 FROM PUBLIC;
GRANT CONNECT ON DATABASE template1 TO PUBLIC;


--
-- PostgreSQL database dump complete
--

--
-- Database "BDAssistance" dump
--

--
-- PostgreSQL database dump
--

-- Dumped from database version 14.6 (Debian 14.6-1.pgdg110+1)
-- Dumped by pg_dump version 14.6 (Debian 14.6-1.pgdg110+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: BDAssistance; Type: DATABASE; Schema: -; Owner: root
--

CREATE DATABASE "BDAssistance" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'en_US.utf8';


ALTER DATABASE "BDAssistance" OWNER TO root;

\connect "BDAssistance"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: asistencia; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.asistencia (
    id integer NOT NULL,
    id_empleado integer NOT NULL,
    fecha date NOT NULL,
    hora character varying(15) NOT NULL
);


ALTER TABLE public.asistencia OWNER TO root;

--
-- Name: asistencia_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE public.asistencia_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.asistencia_id_seq OWNER TO root;

--
-- Name: asistencia_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE public.asistencia_id_seq OWNED BY public.asistencia.id;


--
-- Name: departamento; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.departamento (
    id integer NOT NULL,
    nombre character varying(40)
);


ALTER TABLE public.departamento OWNER TO root;

--
-- Name: departamento_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE public.departamento_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.departamento_id_seq OWNER TO root;

--
-- Name: departamento_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE public.departamento_id_seq OWNED BY public.departamento.id;


--
-- Name: empleado; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.empleado (
    id integer NOT NULL,
    id_departamento integer NOT NULL,
    nombre character varying(30) NOT NULL,
    email character varying(30),
    contrasena character varying(30) NOT NULL
);


ALTER TABLE public.empleado OWNER TO root;

--
-- Name: asistencia id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.asistencia ALTER COLUMN id SET DEFAULT nextval('public.asistencia_id_seq'::regclass);


--
-- Name: departamento id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.departamento ALTER COLUMN id SET DEFAULT nextval('public.departamento_id_seq'::regclass);


--
-- Data for Name: asistencia; Type: TABLE DATA; Schema: public; Owner: root
--

COPY public.asistencia (id, id_empleado, fecha, hora) FROM stdin;
9	11111111	2022-09-01	15:08:23
10	72032363	2022-12-09	17:58:55
11	17489502	2022-12-11	00:36:32
12	16789823	2022-10-28	18:37:52
13	22694792	2022-09-08	15:30:40
14	23263756	2022-09-08	15:35:50
15	24743385	2022-09-18	16:15:20
16	25546888	2022-09-22	15:18:29
17	26737523	2022-09-22	14:18:49
18	27599253	2022-09-24	15:48:09
19	28456322	2022-09-30	16:10:01
20	32952649	2022-10-05	15:25:41
21	33343982	2022-10-05	18:30:11
22	35545499	2022-10-11	16:15:22
23	45799443	2022-10-11	18:40:35
24	48482882	2022-10-18	15:10:15
25	58799654	2022-10-20	00:22:08
26	62965893	2022-10-24	13:30:28
27	63465537	2022-11-10	14:10:01
28	63587744	2022-11-11	15:30:41
29	64238493	2022-11-12	14:25:11
30	66474624	2022-11-12	15:32:22
31	69728459	2022-11-15	18:12:42
32	70426229	2022-11-15	17:00:42
33	48955065	2022-11-20	15:35:02
34	48744064	2022-11-20	15:10:20
35	43069149	2022-11-23	14:08:19
36	77551199	2022-11-23	00:28:06
37	57681329	2022-11-27	00:30:46
38	88375534	2022-11-14	13:00:46
39	63052256	2022-11-15	15:18:06
40	33705547	2022-10-18	15:31:26
41	48729574	2022-10-19	16:31:16
42	79245076	2022-10-19	18:11:18
43	44629236	2022-10-22	00:11:05
44	32260440	2022-12-12	00:25:15
45	81415558	2022-12-14	00:35:08
46	88488999	2022-12-18	17:35:28
47	52495399	2022-12-20	18:05:18
48	75740125	2022-09-08	16:15:45
49	34993136	2022-12-12	16:15:25
50	56213882	2022-12-12	13:25:15
51	19881498	2022-12-12	14:18:01
52	18557617	2022-12-12	13:08:57
53	60564887	2022-12-13	13:48:47
54	71871771	2022-12-13	15:10:17
55	26732826	2022-12-11	17:10:02
56	41013817	2022-12-13	14:03:12
57	87798860	2022-11-12	00:03:02
58	52554071	2022-11-28	11:13:42
59	80303287	2022-11-15	10:04:02
60	45748989	2022-11-14	18:04:22
61	78086801	2022-11-13	17:14:02
62	28926247	2022-11-11	14:25:12
64	56259296	2022-11-08	13:05:57
65	67922109	2022-11-07	14:35:17
66	30662358	2022-11-05	00:05:17
67	26622352	2022-10-25	18:35:47
68	9074286	2022-10-20	17:15:07
69	75304902	2022-10-12	14:13:29
70	62714970	2022-10-05	15:10:05
71	9387919	2022-10-18	17:30:45
72	83138741	2022-12-12	18:30:50
73	76383350	2022-12-01	15:30:50
\.


--
-- Data for Name: departamento; Type: TABLE DATA; Schema: public; Owner: root
--

COPY public.departamento (id, nombre) FROM stdin;
1	Marketing
2	Ventas
3	Logistica
4	Tic
6	RR.HH
7	Contabilidad
8	Control Interno
\.


--
-- Data for Name: empleado; Type: TABLE DATA; Schema: public; Owner: root
--

COPY public.empleado (id, id_departamento, nombre, email, contrasena) FROM stdin;
11111111	6	Geraldo Quispe	geralquis@hotmail.com	admin123
72032363	4	Manuel Sanchez	u20303242@utp.edu.pe	manu123
78239198	1	Carmen Aguinaga	caraqui@gmail.com	ungato
16789823	3	Pablo Inglesias	pabing@hotmail.com	peliculas
17489502	8	Jorge Perales	jorper@hotmail.com	salmon
22222222	6	Roberto Martinez	micorreorb@live.com	admin456
16726028	8	Monica	correomonica@gmail.com	monica75
25298767	3	Raul	raulito@live.com	contrasena
17895783	7	Julia	julita@hotmail.com	contabilidad
22694792	1	Ingrid	marta-c2002@gmail.com	Ta1PIt12
23263756	3	Maritza	mailane43@gmail.com	MIgLkWA1
24743385	2	Osvaldo	iki_rojo@gmail.com	H0RHoude
25546888	8	Camila	Katty_magda20@gmail.com	cHAR4gen
26737523	1	Ignacio Carranza	Ibarra_32@gmail.com	IDAZiRArS
27599253	4	Daniela Aguilera	daniela_aguilera@gmail.com	RIStaBRiM
28456322	8	Andrea Tafur	marissa-leo01@gmail.com	andOsabiA
32952649	2	Paula Arias	Paula2002_farya@gmail.com	isMASeria
33343982	3	Marily Cubas	Mari10_edo@gmail.com	APheATENg
35545499	7	Elizabeth Fernandez	elizabet39@gmail.com	lFREsdape
45799443	7	Johanna Gonzales	joy_pao_@gmail.com	MoPo41TAT
48482882	2	Claudia Bergez	claudia_bergez@gmail.com	GheRmouTe
58799654	4	Sergio Herrera	sergio_herrera2005@gmail.com	EURsibUsi
62965893	7	Marcelo Ortega	juan-Marc_21@gmail.com	liC5ENVI
63465537	6	Gianfranco Campos	ruli-andr0@gmail.com	I08RGEnGU
63587744	2	Pablo Cardenas	pablo_0l44@gmail.com	IreMORA
64238493	6	German Torres	campos_0fray@gmail.com	SOnoWNEoP
66474624	8	Raul Cordova	joaco-cordova@gmail.com	tOrPERiCh
69728459	1	Ivan Calderon	1calderon_SR@gmail.com	RUgaRaxOT
70426229	8	Felipe Mallqui	dante_ol42@gmail.com	shAmishOU
48955065	7	Maria Ramos	dabela_26@gmail.com	ftQ1ZF87
48744064	3	Esmeralda Carranza	Esme_Carraza-03@gmail.com	yJ37nT9m
43069149	1	Roxana Navarro	roxa-09-Nav@gmail.com	3Fxjm82y
77551199	6	Anderson Balladares	Anderson_20@gmail.com	bJ81j9WT
57681329	7	Gabriela Aragon	Gabi-Aragon8@gmail.com	yH68878B
88375534	3	Bryan Prado	BryanPra_05@gmail.com	kY181kfe
63052256	1	Alan Chavez	racox20_22@gmail.com	7OP5k0QV
33705547	6	Estefani Arqui├▒o	nada-rij1@gmail.com	131QZypC
48729574	6	Eduardo Ramirez	EduaR-a8@gmail.com	l901MpE
79245076	1	Marcos Mendoza	Marc-z4@gmail.com	k63N2LI
44629236	7	Melody Rueda	resi_Mel24@gmail.com	zHP38T6
32260440	2	Samantha Vasquez	Saka_32@gmail.com	D3jQ93S
81415558	6	Luis Quispe	loxel_ka25@gmail.com	5Rq63OQ
88488999	3	Diana Rojas	rebeyi6@gmail.com	R1jXU30
52495399	8	Cristina Quiroz	poce-Quiroz_09@gmail.com	18g0Gv3
75740125	6	Fatima Alvan	sicoy-Alvan@gmail.com	859G2Zq
34993136	8	Gian Carlos Mantari	riTari_Ca@gmail.com	g4A0B3
56213882	1	Lucia Barboza	Luci_cej15@gmail.com	iU0u51
19881498	3	Julia Hurtado	lay_Hurtado@gmail.com	7ruH40
18557617	4	Ketty Garro	vehe-20o@gmail.com	h8W630
60564887	4	Jhonny Barrios	Jhony_Ba@edinel.com@gmail.com	s491Hb
71871771	2	Analy Monserrat	diima_202a@gmail.com	7lE0V8
26732826	6	Rodrigo Rojas	Ro_Rojas74@gmail.com	6mM4P3
41013817	1	Gabriel Lazaro	geco-fe1@gmail.com	633tDf
87798860	7	Miguel Chapo├▒an	Migar_C65@gmail.com	8Td4K2
52554071	6	Jeny Santos	yosaha7@gmail.com	d4H30L
80303287	2	Mirella Guerrero	savel5_Mire@gmail.com	0z57Hd
45748989	1	Lisbeth Cubas	Lisbet_49@gmail.com	257T2d
78086801	1	Paola Delgado	Pao_Delg20@gmail.com	jG2J27
28926247	4	Yessica Perez	Xoa-Perez@gmail.com	4B3c87
56259296	1	Santiago Mendoza	Mye_l3@gmail.com	796oPe
67922109	1	Maria Fernanda	Mafer_Vega@gmail.com	9I8g4k
30662358	3	Alessandro Cabrera	Alex_C12@gmail.com	N101Uq
26622352	6	Valeria Vargas	caxam-Varg_09@gmail.com	8V50zZ
9074286	7	Angie Melendez	Angie_47@gmail.com	gU49x7
75304902	2	Geraldine Cordova	Geral_tatia12@gmail.com	wZT620
62714970	3	Cinthia Estela	Estela_25_ol@gmail.com	4m09MZ
9387919	8	Jesus Olivares	jesus_ol25@gmail.com	r074V0
83138741	7	Marcela Castro	Marcela_10@gmail.com	6u02Nz
76383350	1	Ruth Vaneza	Ruth_Van26@gmail.com	r4HY91
\.


--
-- Name: asistencia_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('public.asistencia_id_seq', 73, true);


--
-- Name: departamento_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('public.departamento_id_seq', 8, true);


--
-- Name: asistencia asistencia_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.asistencia
    ADD CONSTRAINT asistencia_pkey PRIMARY KEY (id);


--
-- Name: departamento departamento_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.departamento
    ADD CONSTRAINT departamento_pkey PRIMARY KEY (id);


--
-- Name: empleado empleado_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.empleado
    ADD CONSTRAINT empleado_pkey PRIMARY KEY (id);


--
-- Name: asistencia asistencia_id_empleado_fkey; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.asistencia
    ADD CONSTRAINT asistencia_id_empleado_fkey FOREIGN KEY (id_empleado) REFERENCES public.empleado(id);


--
-- Name: empleado empleado_id_departamento_fkey; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.empleado
    ADD CONSTRAINT empleado_id_departamento_fkey FOREIGN KEY (id_departamento) REFERENCES public.departamento(id);


--
-- PostgreSQL database dump complete
--

--
-- Database "postgres" dump
--

--
-- PostgreSQL database dump
--

-- Dumped from database version 14.6 (Debian 14.6-1.pgdg110+1)
-- Dumped by pg_dump version 14.6 (Debian 14.6-1.pgdg110+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE postgres;
--
-- Name: postgres; Type: DATABASE; Schema: -; Owner: root
--

CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'en_US.utf8';


ALTER DATABASE postgres OWNER TO root;

\connect postgres

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: DATABASE postgres; Type: COMMENT; Schema: -; Owner: root
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- PostgreSQL database dump complete
--

--
-- PostgreSQL database cluster dump complete
--

