SELECT au.username username, c."name" category_name, f2.question questions, f2.question answers_flash
FROM study_set ss , flashcard f2 , category c , app_user au
WHERE ss.owner_id= 4;