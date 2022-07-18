import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MoviesRoutingModule } from './movies-routing.module';
import { MovieListComponent } from './components/movie-list/movie-list.component';
import { MoviesViewComponent } from './views/movies-view/movies-view.component';
import { MovieDetailComponent } from './components/movie-detail/movie-detail.component';
import {UiModule} from "../../ui/ui.module";
import {MovieListContainerComponent} from "./components/movie-list/movie-list.container";


@NgModule({
  declarations: [
    MovieListComponent,
    MoviesViewComponent,
    MovieDetailComponent,
    MovieListContainerComponent
  ],
  imports: [
    CommonModule,
    MoviesRoutingModule,
    UiModule
  ]
})
export class MoviesModule { }
