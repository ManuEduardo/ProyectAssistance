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

-- Dumped from database version 14.5 (Debian 14.5-1.pgdg110+1)
-- Dumped by pg_dump version 14.5 (Debian 14.5-1.pgdg110+1)

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

-- Dumped from database version 14.5 (Debian 14.5-1.pgdg110+1)
-- Dumped by pg_dump version 14.5 (Debian 14.5-1.pgdg110+1)

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
    fecha date NOT NULL
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

COPY public.asistencia (id, id_empleado, fecha) FROM stdin;
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
\.


--
-- Name: asistencia_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('public.asistencia_id_seq', 1, false);


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

-- Dumped from database version 14.5 (Debian 14.5-1.pgdg110+1)
-- Dumped by pg_dump version 14.5 (Debian 14.5-1.pgdg110+1)

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

