import {Component, Input, OnInit} from '@angular/core';
import {Movie} from "../../../../core/models/movie.model";
import {MovieService} from "../../../../core/services/movie.service";

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {

  @Input() movies: Movie[] = [];

  constructor(
    private movieService: MovieService
  ) { }

  ngOnInit(): void {
    this.movies = this.movieService.getMovies();
  }

}
