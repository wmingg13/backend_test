SELECT * FROM (
    SELECT p.name, s.sport, s.total_score
    FROM players p, scores s
    WHERE p.player_no = s.player_no
    ORDER BY s.total_score DESC;
);