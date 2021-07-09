export class User {
    id!: number;
    firstName!: string;
    lastName!: string;
    phone!: string;
    pseudonym!: string;
    password!: string;
    email!: string;
    inscritptionDate!: Date;
    urlAvatar!: string;
    description!: string;

  get getId(){
      return this.id;
  }

  public set setId(newId: number) {
    
    this.id = newId;
}
}
