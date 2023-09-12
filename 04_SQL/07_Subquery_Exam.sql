-- 07_Subquery_Exam.sql
-- 서브쿼리(자식쿼리) 연습문제
-- 연습문제 1) (사원번호가(ENO) 7788인 사원)과 
--   담당 업무가(JOB) 같은 사원을(사원이름(ENAME),담당업무(JOB)) 표시하세요.
-- 대상 : EMPLOYEE
-- 1) (사원번호가(ENO) 7788인 사원)
SELECT JOB FROM EMPLOYEE
WHERE ENO = 7788; -- ANALYST

-- 2) ANALYST 와 같은 업무를 가진 사원 출력
SELECT ENAME, JOB FROM EMPLOYEE
WHERE JOB = 'ANALYST';

-- 서브쿼리 사용
SELECT ENAME, JOB FROM EMPLOYEE
WHERE JOB = (SELECT JOB FROM EMPLOYEE WHERE ENO = 7788);
 
-- 연습문제 2) (사원번호가(ENO) 7499인 사원)보다 
--   급여가(SALARY) 많은 사원을(사원이름(ENAME),담당업무(JOB)) 표시하세요. 
-- 대상 : EMPLOYEE
-- 1) 사원번호가(ENO) 7499인 사원의 급여(SALARY)
SELECT SALARY FROM EMPLOYEE
WHERE ENO = 7499; -- 1600

-- 2) 급여가 1600 보다 큰 사원의 사원이름(ENAME), 담당업무(JOB)를 화면에 표시
SELECT ENAME, JOB FROM EMPLOYEE
WHERE SALARY > 1600;

-- 최종쿼리
SELECT ENAME, JOB FROM EMPLOYEE
WHERE SALARY > (SELECT SALARY FROM EMPLOYEE WHERE ENO = 7499);

-- 연습문제 3) (최소(MIN) 급여를(SALARY) 받는 사원)의 이름,(ENAME) 
--    담당 업무(JOB) 및 급여(SALARY)를 표시하세요.
-- 대상 : EMPLOYEE
-- 1) 최소(MIN) 급여를(SALARY) 받는 사원의 급여
SELECT MIN(SALARY) FROM EMPLOYEE; -- 800

-- 2) 최소급여 800을 받는 사원 사원이름(ENAME), 담당업무(JOB)를 화면에 표시
SELECT ENAME, JOB, SALARY FROM EMPLOYEE
WHERE SALARY = 800;

-- 3) 최종쿼리
SELECT ENAME, JOB, SALARY FROM EMPLOYEE
WHERE SALARY = (SELECT MIN(SALARY) FROM EMPLOYEE);

-- 연습문제 4) 평균 급여가(SALARY) 가장 적은(MIN) 사원의 담당 업무(JOB)를 찾아 
--    직급과(JOB) 평균(AVG) 급여를(SALARY) 표시하세요.
--  (설명) == (담당 업무별 평균 급여가 가장 적은) 사람을 찾아 
--    직급과 평균 급여를 표시하세요.
-- 단, 소수점 나오면 반올림하기(첫째자리에서)
-- 힌트) 4-1) (담당 업무별 평균 급여가 가장 적은) 사람
SELECT MIN(ROUND(AVG(SALARY),1))
FROM EMPLOYEE
GROUP BY JOB; -- 1037.5

-- 4-2) 그 사람의 직급과 평균급여 화면에 출력 : 그 사람의 직급별 평균급여를 화면에 출력
SELECT JOB, ROUND(AVG(SALARY),1)
FROM EMPLOYEE
GROUP BY JOB
HAVING ROUND(AVG(SALARY),1) = 1037.5 ;

-- 최종쿼리
SELECT JOB, ROUND(AVG(SALARY),1)
FROM EMPLOYEE
GROUP BY JOB
HAVING ROUND(AVG(SALARY),1) = (SELECT MIN(ROUND(AVG(SALARY),1))
                               FROM EMPLOYEE
                               GROUP BY JOB);
                               
-- 연습문제 5) (각 부서의 최소(MIN) 급여(SALARY))를 받는 
--   사원의 이름(ENAME), 급여(SALARY), 부서번호(DNO)를 표시하세요.
-- 1) 각 부서의(부서별) 최소 급여를 받는 사원의 최소 급여
SELECT MIN(SALARY) FROM EMPLOYEE
GROUP BY DNO; -- 950, 1300, 800

-- 2) (950, 1300, 800) 급여를 받는 사원의 이름, 급여, 부서번호를 표시
SELECT ENAME, SALARY, DNO
FROM EMPLOYEE
WHERE SALARY IN (950, 1300, 800);

-- 최종쿼리
SELECT ENAME, SALARY, DNO 
FROM EMPLOYEE
WHERE SALARY IN (SELECT MIN(SALARY) FROM EMPLOYEE
                 GROUP BY DNO);

-- 연습문제 6) 매니저가(MANAGER) 없는 사원의 이름을(ENAME) 표시하세요.
-- 1) 매니저가 없는 사원의 사원번호
SELECT ENO FROM EMPLOYEE
WHERE MANAGER IS NULL; -- 7839

-- 2) 그 사람의 이름을 화면에 출력
SELECT ENAME FROM EMPLOYEE
WHERE ENO = 7839;

-- 최종쿼리
SELECT ENAME FROM EMPLOYEE
WHERE ENO = (SELECT ENO FROM EMPLOYEE
             WHERE MANAGER IS NULL);