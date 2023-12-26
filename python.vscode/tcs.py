# Define a function to calculate net run rate
def calculate_net_run_rate(runs_scored, balls_played):
    return (runs_scored / balls_played) * 120 - 6

# Process match results
matches = []
for _ in range(54):
    match_result = input().strip().split()
    first_team, first_score, first_wickets, first_balls, second_team, second_score, second_wickets, second_balls = match_result
    first_runs, second_runs = int(first_score.split('/')[0]), int(second_score.split('/')[0])
    first_balls, second_balls = int(first_balls), int(second_balls)

    matches.append({
        'team1': first_team,
        'team2': second_team,
        'team1_runs': first_runs,
        'team2_runs': second_runs,
        'team1_balls': first_balls,
        'team2_balls': second_balls
    })

# Process rankings
rankings = []
for _ in range(8):
    rankings.append(input().strip())

# Calculate points and net run rates for each team
team_data = {}
for match in matches:
    if match['team1_runs'] > match['team2_runs']:
        winner, loser = match['team1'], match['team2']
        winner_runs, loser_runs = match['team1_runs'], match['team2_runs']
        winner_balls, loser_balls = match['team1_balls'], match['team2_balls']
    else:
        winner, loser = match['team2'], match['team1']
        winner_runs, loser_runs = match['team2_runs'], match['team1_runs']
        winner_balls, loser_balls = match['team2_balls'], match['team1_balls']

    if winner not in team_data:
        team_data[winner] = {'points': 0, 'net_run_rate': 0}
    if loser not in team_data:
        team_data[loser] = {'points': 0, 'net_run_rate': 0}

    team_data[winner]['points'] += 2
    team_data[loser]['points'] += 0
    team_data[winner]['net_run_rate'] += calculate_net_run_rate(winner_runs, winner_balls)
    team_data[loser]['net_run_rate'] += calculate_net_run_rate(loser_runs, loser_balls)

# Generate possible outcomes for remaining matches
remaining_matches = [('DC', 'RR'), ('SRH', 'KKR')]

valid_outcomes = []
for outcome in [(0, 0), (0, 2), (2, 0), (2, 2)]:
    team1_win, team2_win = remaining_matches[outcome[0]], remaining_matches[outcome[1]]
    new_team_data = team_data.copy()

    new_team_data[team1_win]['points'] += 2
    new_team_data[team2_win]['points'] += 0

    new_team_data[team1_win]['net_run_rate'] += 120  # Assume a large margin of victory
    new_team_data[team2_win]['net_run_rate'] -= 120

    # Check if the rankings are valid
    new_rankings = sorted(rankings, key=lambda x: (new_team_data[x.split()[0]]['points'], new_team_data[x.split()[0]]['net_run_rate']), reverse=True)
    if rankings == new_rankings:
        valid_outcomes.append(f"WIN:{team1_win}|LOSE:{team2_win}||WIN:{team2_win}|LOSE:{team1_win}")

# Print valid outcomes in lexicographical order
valid_outcomes.sort()
for outcome in valid_outcomes:
    print(outcome)
