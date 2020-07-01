SELECT title FROM film WHERE film_id IN 
       (SELECT inventory.film_id FROM inventory NATURAL JOIN rental) AND 
       	       film_id NOT IN 
	       	       (SELECT inventory.film_id FROM inventory, rental, customer WHERE inventory.inventory_id = rental.inventory_id AND 
rental.customer_id = customer.customer_id AND 
customer.first_name = 'LEE' AND customer.last_name = 'DAVIS') 


ORDER BY title ASC;