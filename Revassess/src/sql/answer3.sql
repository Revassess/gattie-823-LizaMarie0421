SELECT * FROM app_user au
	JOIN study_set ss 
	ON au.user_id = ss.owner_id 
	WHERE user_id = 5;
	