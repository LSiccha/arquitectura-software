import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {MoviesViewComponent} from "./views/movies-view/movies-view.component";
import {MovieListComponent} from "./components/movie-list/movie-list.component";
import {MovieDetailComponent} from "./components/movie-detail/movie-detail.component";

const routes: Routes = [
  {
    path: '',
    component: MoviesViewComponent,
    children:[
      {
        path:'',
        component: MovieListComponent
      },
      {
        path:'detail/:id',
        component: MovieDetailComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MoviesRoutingModule { }
