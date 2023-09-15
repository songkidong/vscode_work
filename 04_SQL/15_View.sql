-- 15_View.sql
-- 뷰(View) : 하나 이상의 테이블이나 다른 뷰를 이용해서 생성하는 가상의 테이블
-- 활용) 1) 보안을 유지하기 위해 사용 : 사원테이블 - 급여컬럼(비밀 유지:대외비)
--      2) SQL 문을 미리 만들어 놓고 재활용 : 코딩 생산성 향상
-- 1) 뷰 생성
-- 사용법) CREATE OR REPLACE VIEW 뷰이름(컬럼명, 컬럼명2, ...)
--        AS
--        SELECT 원본컬럼명, 원본컬럼명2, ...
--        FROM 테이블명
--        WHERE 조건절;
CREATE OR REPLACE VIEW VW_EMP_JOB(사번, 사원이름, 부서번호, 담당업무)
AS
SELECT ENO, ENAME, DNO, JOB
FROM EMPLOYEE
WHERE JOB LIKE 'SALESMAN%';

-- 2) 뷰 사용 : 일반 SELECT 문에 뷰이름으로 조회하면 됨
-- 사용법) SELECT * FROM 뷰이름;
SELECT * FROM VW_EMP_JOB;

-- 예제1) 부서테이블과(DEPARTMENT) 사원테이블을(EMPLOYEE)조인한 결과를 뷰로 만들어서 출력하세요
-- 뷰이름 : VW_EMP_COMPLEX
-- 열명은 중복이 안되게 지정
-- 뷰 생성
CREATE OR REPLACE VIEW VW_EMP_COMPLEX
AS
SELECT EMP.*, DEP.DNAME, DEP.LOC
FROM EMPLOYEE EMP
    ,DEPARTMENT DEP
WHERE EMP.DNO = DEP.DNO;

-- 뷰 사용
SELECT * FROM VW_EMP_COMPLEX;

-- 뷰 정보 확인 : 데이터사전(시스템테이블:관리용(미리생성되어 있음) : USER_VIEWS
SELECT * FROM USER_VIEWS;

-- 뷰에 INSERT 가능한가? O
-- 예제 2) VW_EMP_JOB 에 INSERT 하기
-- 뷰컬럼 : 사번, 사원이름, 부서번호, 담당업무
INSERT INTO VW_EMP_JOB
VALUES(8000, '송기동', 30, 'SALESMAN');
COMMIT;
SELECT * FROM VW_EMP_JOB;

-- 예제3) 뷰에 그룹함수 써서 만들기
-- 그룹함수 : SUM, AVG, COUNT, MAX, MIN 등
-- 부서별(DNO) 급여합계(SUM(SALARY)), 급여평균(AVG(SALARY))을 
-- 출력하는 SQL문을 뷰로 만드세요
-- 출력 : DNO, SUM(SALARY), AVG(SALARY)
-- 뷰이름 : VW_EMP_SALARY
-- 대상테이블 : EMPLOYEE
-- 힌트 : 컬럼에 별칭을 부여하세요.
--      급여합계 : SAL_SUM
--      급여평균 : SAL_AVG
-- 뷰 생성시 그룹함수는 별명이 필요함
CREATE OR REPLACE VIEW VW_EMP_SALARY
AS
SELECT DNO
,SUM(SALARY) AS SAL_SUM
,ROUND(AVG(SALARY),1) AS SAL_AVG
FROM EMPLOYEE
GROUP BY DNO;
-- 조회
SELECT * FROM VW_EMP_SALARY;

-- 그룹함수로 만든 뷰 INSERT 가능한가? X
-- DNO SAL_SUM SAL_AVG
INSERT INTO VW_EMP_SALARY
VALUS(30, 1000, 3000); -- 에러

-- 뷰 삭제
-- 사용법) DROP VIEW 뷰이름;
DROP VIEW VW_EMP_SALARY;

-- (참고) 뷰에 INSERT 기본 가능(그룹함수 없을때)
-- 뷰에 INSERT 기능 제한 : 옵션 추가 : WITH READ ONLY
-- 예제 4) WITH READ ONLY 옵션을 붙여서 뷰 만들기
-- SQL : 직위가 MANAGER 인 사원을 출력하는 뷰 만들기
CREATE OR REPLACE VIEW VW_EMP_JOB_READONLY
AS
SELECT ENO, ENAME, DNO, JOB
FROM EMPLOYEE
WHERE JOB LIKE '%MANAGER%' WITH READ ONLY;
-- INSERT 테스트
INSERT INTO VW_EMP_JOB_READONLY
VALUES(9000, '김주현', 30, 'MANAGER'); -- 에러 발생

