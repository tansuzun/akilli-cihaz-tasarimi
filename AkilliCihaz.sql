--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-05-17 02:10:11

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
-- TOC entry 2990 (class 1262 OID 65623)
-- Name: dbAkilliCihaz; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "dbAkilliCihaz" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Turkish_Turkey.1254';


ALTER DATABASE "dbAkilliCihaz" OWNER TO postgres;

\connect "dbAkilliCihaz"

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
-- TOC entry 200 (class 1259 OID 65624)
-- Name: Users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Users" (
    id integer NOT NULL,
    username character varying(30) NOT NULL,
    password character varying(40) NOT NULL,
    email character varying(100)
);


ALTER TABLE public."Users" OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 65630)
-- Name: Users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Users_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Users_id_seq" OWNER TO postgres;

--
-- TOC entry 2991 (class 0 OID 0)
-- Dependencies: 201
-- Name: Users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Users_id_seq" OWNED BY public."Users".id;


--
-- TOC entry 2850 (class 2604 OID 65632)
-- Name: Users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Users" ALTER COLUMN id SET DEFAULT nextval('public."Users_id_seq"'::regclass);


--
-- TOC entry 2983 (class 0 OID 65624)
-- Dependencies: 200
-- Data for Name: Users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Users" (id, username, password, email) VALUES (1, 'tansu', '123', NULL);
INSERT INTO public."Users" (id, username, password, email) VALUES (4, 'test', '111', NULL);
INSERT INTO public."Users" (id, username, password, email) VALUES (16, 'deneme', 'deneme', 'deneme@gmail.com');
INSERT INTO public."Users" (id, username, password, email) VALUES (17, 'test', '12', 'test@gmail.com');


--
-- TOC entry 2992 (class 0 OID 0)
-- Dependencies: 201
-- Name: Users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Users_id_seq"', 17, true);


--
-- TOC entry 2852 (class 2606 OID 73832)
-- Name: Users Users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Users"
    ADD CONSTRAINT "Users_pkey" PRIMARY KEY (id);


-- Completed on 2021-05-17 02:10:11

--
-- PostgreSQL database dump complete
--

