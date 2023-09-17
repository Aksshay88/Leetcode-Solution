select row_number() over(order by floor(id/2)+id%2, id%2 ) as id,student
from seat ;