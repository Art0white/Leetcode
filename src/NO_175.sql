
# LeetCode 175.组合两个表
select firstName, lastName, city, state
from Person left join Address
    on Person.PersonId = Address.PersonId;