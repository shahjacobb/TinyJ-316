;;; Shah Bhuiyan 

;;; Solution to Problem 1
(defun min-2 (a b)
  (if (and (numberp a) (numberp b))
      (if (<= a b) a b)
      ('error)))


;;; Solution to Problem 2
(defun safe-avg (a b)
  (if (and (numberp a) (numberp b))
      (/ (+ a b) 2)
      nil))

;;; Solution to Problem 3
(defun odd-gt-million (x)
  (and (integerp x)
       (> x 1000000)
       (oddp x)))

;;; Could not figure out problem 5.

;;; Solution to Problem 5
(defun month->integer (month)
  (cond ((equal month 'JANUARY) 1)
        ((equal month 'FEBRUARY) 2)
        ((equal month 'MARCH) 3)
        ((equal month 'APRIL) 4)
        ((equal month 'MAY) 5)
        ((equal month 'JUNE) 6)
        ((equal month 'JULY) 7)
        ((equal month 'AUGUST) 8)
        ((equal month 'SEPTEMBER) 9)
        ((equal month 'OCTOBER) 10)
        ((equal month 'NOVEMBER) 11)
        ((equal month 'DECEMBER) 12)
        (t 'error)))


;;; Solution to Problem 6
(defun score->grade (s)
  (cond ((not (numberp s)) nil)
        ((and (>= s 90) (<= s 100)) 'A)
        ((and (>= s 87) (< s 90)) 'A-)
        ((and (>= s 83) (< s 87)) 'B+)
        ((and (>= s 80) (< s 83)) 'B)
        ((and (>= s 77) (< s 80)) 'B-)
        ((and (>= s 73) (< s 77)) 'C+)
        ((and (>= s 70) (< s 73)) 'C)
        ((and (>= s 60) (< s 70)) 'D)
        ((< s 60) 'F)))


;;; Solution to Problem 7
(defun gt (a b)
  (and (numberp a)         
       (numberp b)         
       (> a b)))           

;;; Solution to Problem 8
(defun same-parity (a b)
  (and (integerp a)                
       (integerp b)                
       (or (and (evenp a) (evenp b))   
           (and (oddp a) (oddp b))))) 

;;; Solution to Problem 9
(defun safe-div (a b)
  (and (numberp a)              
       (numberp b)               
       (not (zerop b))          
       (/ a b)))                 
